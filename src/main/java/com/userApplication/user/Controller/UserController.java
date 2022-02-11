package com.userApplication.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.userApplication.user.Entity.AuthenticationRequest;
import com.userApplication.user.Entity.AuthernticationResponse;
import com.userApplication.user.Security.MyUserDetailsService;
import com.userApplication.user.Service.UserService;
import com.userApplication.user.Utility.JwtUtil;

@Controller
public class UserController {
	@Autowired
	public MyUserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@Autowired
	public JwtUtil jwtUtil;
	
	@GetMapping(path = "/test")
	@ResponseBody
	public String testAPI() {
		return "The API test is working";
	}
	
	@RequestMapping(path="/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String RegisterUser(@RequestBody AuthenticationRequest authenticationRequest) {
		AuthenticationRequest auRequest=new AuthenticationRequest(authenticationRequest.getUsername(),authenticationRequest.getPassword());
		return userService.saveUser(auRequest);
	}
	
	@PostMapping(path="/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
					
					
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrrect username or password", e);
		}
		final UserDetails userDetails= userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt=jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthernticationResponse(jwt));
	}
}
