package com.pjsoft.fms.service.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.config.JwtUtil;
import com.pjsoft.fms.controller.UserController;
import com.pjsoft.fms.dto.AuthRequest;
import com.pjsoft.fms.dto.AuthRequest;
import com.pjsoft.fms.dto.AuthResponse;
import com.pjsoft.fms.dto.UserRequest;
import com.pjsoft.fms.dto.UserResponse;
import com.pjsoft.fms.model.User;
import com.pjsoft.fms.repository.UserRepository;


@Service
public class UserService {
	
	private Logger log=LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private  PasswordEncoder passwordEncoder;
	@Autowired
	private AuthUserDetailsService authUserDetailsService;
	@Autowired
	public JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	



	public UserResponse createUser(UserRequest userRequest) {
		log.info("pass-> {}", userRequest.getPassword());
		userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		log.info("pass encode-> {}", userRequest.getPassword());
		User user = new User(userRequest.getName(), userRequest.getUsername(), userRequest.getPassword(),userRequest.getEmail());
//		User user=new User("Anshul", "anshul", passwordEncoder.encode("ansh123"));
		log.info("pass encode-> {}", user.getPassword());
		user = userRepository.save(user);
		return new UserResponse(user.getId(), user.getName(), user.getUsername());

	}
	
	public AuthResponse userLogin(AuthRequest authRequest) throws Exception {
		authenticate(authRequest.getUsername(), authRequest.getPassword());
 
		final UserDetails userDetails = authUserDetailsService.loadUserByUsername(authRequest.getUsername());
 
		final String token = jwtUtil.generateToken(userDetails.getUsername());
 
		return new AuthResponse(authRequest.getUsername(), token);
	}
 
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	public List<String> getAllUsers(){
		return userRepository.findAll().stream().map(User::getName).collect(Collectors.toList());
	}
	
	

}
