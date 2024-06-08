package com.carservice.services;

import com.carservice.data.entities.User;

public interface UserService {
	User saveUser(User user);

	User loadUserByUsername(String username);

	boolean checkPassword(User user, String rawPassword);
}