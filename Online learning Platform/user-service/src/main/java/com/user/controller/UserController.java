package com.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return service.getUserById(id);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return "User deleted successfully!";
	}

}