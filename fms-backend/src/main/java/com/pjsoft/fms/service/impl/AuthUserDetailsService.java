package com.pjsoft.fms.service.impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.model.AuthUserDetail;
import com.pjsoft.fms.model.User;
import com.pjsoft.fms.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthUserDetailsService implements UserDetailsService {
 
	private final UserRepository userRepository;
 
	public AuthUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findUserByUsername(username);
 
		if (!userOptional.isPresent()) {
			throw new EntityNotFoundException("User does not exist here");
		}
		User user = userOptional.get();
		return new AuthUserDetail(user);
	}
}