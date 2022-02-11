package com.userApplication.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userApplication.user.Entity.AuthenticationRequest;

//not used now added because JPA dependecy was added
@Repository
//public interface UserRepository extends JpaRepository<User, String>{
public interface UserRepository extends JpaRepository<AuthenticationRequest, String>{

}
