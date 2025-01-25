package com.pjsoft.fms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjsoft.fms.dto.AuthRequest;
import com.pjsoft.fms.dto.AuthResponse;
import com.pjsoft.fms.dto.UserRequest;
import com.pjsoft.fms.dto.UserResponse;
import com.pjsoft.fms.model.User;
import com.pjsoft.fms.service.impl.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private Logger log=LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(path = "/register")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {

		log.info("User creating {}", userRequest);

		UserResponse userResponse = userService.createUser(userRequest);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> loginUser(@RequestBody AuthRequest authRequest) throws Exception{
		log.info("User login {}", authRequest);
		AuthResponse authResponse=userService.userLogin(authRequest);
		return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
		
	}
	
	@GetMapping("/login/users")
	public ResponseEntity<List<String>> getAllUsers(){
		return new ResponseEntity<List<String>>(userService.getAllUsers(),HttpStatus.OK);
		
	}
 

}
