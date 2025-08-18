package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.exception.UserNotFoundException;
import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	   private final UserRepository repo;

	    public UserService(UserRepository repo) {
	        this.repo = repo;
	    }


	    public User saveUser(User user) {
	        return repo.save(user);
	    }


	    public List<User> getAllUsers() {
	        return repo.findAll();
	    }

	    public User getUserById(Long id) {
	        return repo.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
	    }


	    public User updateUser(Long id, User user) {
	        User existing = getUserById(id);
	        existing.setUname(user.getUname());
	        existing.setEmail(user.getEmail());
	        existing.setPwd(user.getPwd());
	        existing.setRole(user.getRole());
	        return repo.save(existing);
	    }


	    public void deleteUser(Long id) {
	        repo.deleteById(id);
	    }
}