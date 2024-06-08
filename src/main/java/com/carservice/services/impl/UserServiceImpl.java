package com.carservice.services.impl;

import com.carservice.data.entities.User;
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

	@Override
	public User loadUserByUsername(String username) {
		return userRepository.findByEmail(username);
	}

	@Override
	public boolean checkPassword(User user, String rawPassword) {
		return passwordEncoder.matches(rawPassword, user.getPassword());
	}
}