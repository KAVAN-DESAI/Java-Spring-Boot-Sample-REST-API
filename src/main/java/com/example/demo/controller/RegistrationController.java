package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.utils.request.RegistrationRequest;
import com.example.demo.utils.response.RegistrationResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<RegistrationResponse> registrationRequest(@Validated @RequestBody RegistrationRequest registrationRequest) {
		final RegistrationResponse registrationResponse = userService.registration(registrationRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}
    
}
