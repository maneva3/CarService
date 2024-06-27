package com.carservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CarCenterNotFoundException extends RuntimeException {
	public CarCenterNotFoundException(String message) {
		super(message);
	}
}
