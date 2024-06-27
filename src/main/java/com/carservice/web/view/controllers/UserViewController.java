package com.carservice.web.view.controllers;

import com.carservice.data.entities.User;
import com.carservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserViewController {
	private final UserService userService;

	// Serve the login page
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	// Handle login form submission
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
		try {
			User user = userService.loadUserByUsername(email);
			if (userService.checkPassword(user, password)) {
				return ResponseEntity.ok("Login successful");
			} else {
				return ResponseEntity.status(401).body("Invalid credentials");
			}
		} catch (Exception e) {
			return ResponseEntity.status(401).body("User not found");
		}
	}

	// Serve the registration page
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}

	// Handle registration form submission
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return ResponseEntity.ok("User registered successfully");
	}
}
