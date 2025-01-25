package com.pjsoft.fms.model;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetail implements UserDetails {
	
	private User user;
	 
	public AuthUserDetail(User user) {
		this.user = user;
	}
 
	private static final long serialVersionUID = -4190360687441421581L;
 
	@Override
	public boolean isEnabled() {
		return true;
	}
 
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
 
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
 
	@Override
	public String getUsername() {
		return user.getUsername();
	}
 
	@Override
	public String getPassword() {
		return user.getPassword();
	}
 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		set.add(new SimpleGrantedAuthority("ADMIN"));
		return set;
	}

}
