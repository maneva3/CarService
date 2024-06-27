package com.carservice.services.impl;

import com.carservice.data.entities.Customer;
import com.carservice.data.entities.Employee;
import com.carservice.data.entities.User;
import com.carservice.exceptions.UserNotFoundException;
import com.carservice.repository.UserRepository;
import com.carservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	// Here the username === email
	@Override
	public User loadUserByUsername(String username) throws UserNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		return user;
	}

	@Override
	public User registerUser(User user, String role) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (role.equalsIgnoreCase("customer")) {
			return userRepository.save((Customer) user);
		} else if (role.equalsIgnoreCase("employee")) {
			return userRepository.save((Employee) user);
		} else {
			throw new IllegalArgumentException("Invalid user type");
		}
	}

	@Override
	public boolean checkPassword(User user, String rawPassword) {
		return passwordEncoder.matches(rawPassword, user.getPassword());
	}
}