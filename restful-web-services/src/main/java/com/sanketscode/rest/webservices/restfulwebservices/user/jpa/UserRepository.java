package com.sanketscode.rest.webservices.restfulwebservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanketscode.rest.webservices.restfulwebservices.user.User;



public interface UserRepository extends JpaRepository<User, Integer>{
	
}