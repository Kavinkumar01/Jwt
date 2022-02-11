package com.userApplication.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userApplication.user.Entity.AuthenticationRequest;
import com.userApplication.user.Repository.UserRepository;

//not used
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepo;
	/*@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	public AuthenticationRequest getUsers(String username) {
		return userRepo.getById(username);
	}

	@Override
	public String saveUser(AuthenticationRequest authenticationRequest) {
		/*AuthenticationRequest authRequest=new AuthenticationRequest(authenticationRequest.getUsername(), bCryptPasswordEncoder.encode(authenticationRequest.getPassword()));
		userRepo.save(authRequest);
		return "The user "+authenticationRequest.getUsername()+" was successfully registered";
		*/
		userRepo.save(authenticationRequest);
		return "The user "+authenticationRequest.getUsername()+" was successfully registered";
	}
	
}
