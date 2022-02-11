package com.userApplication.user.Security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.userApplication.user.Service.UserServiceImpl;
@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserServiceImpl userServiceImpl;
	// This is implemented method from UserDetailsService(It is an Interface which acts like a model object)
	//The username passed is the username for which the data is required(from DB)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//return new User("foo", "foo", new ArrayList<>());
		return new User(userServiceImpl.getUsers(username).getUsername(),userServiceImpl.getUsers(username).getPassword(), new ArrayList<>());
	}

}
