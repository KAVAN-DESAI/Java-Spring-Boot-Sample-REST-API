package com.example.demo.service;

import com.example.demo.utils.response.RegistrationResponse;
import com.example.demo.utils.request.RegistrationRequest;

public interface UserService {

	RegistrationResponse registration(RegistrationRequest registrationRequest);
}
