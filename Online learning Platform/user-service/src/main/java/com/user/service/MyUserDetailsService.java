package com.user.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.repository.UserRepository;
import com.user.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository crepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.user.model.User c = crepo.findByUname(username);

		return new User(c.getUname(), c.getPwd(), Collections.emptyList());
		
		/*
		@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Spring Security's User object
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole()) // STUDENT, TEACHER, ADMIN
                .build();
    }
		 */
	}
}