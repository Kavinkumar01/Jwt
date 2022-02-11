package com.userApplication.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userApplication.user.Entity.AuthenticationRequest;
import com.userApplication.user.Repository.UserRepository;

//not used
@Service
public interface UserService {

	public AuthenticationRequest getUsers(String username);
	public String saveUser(AuthenticationRequest authenticationRequest);
}
