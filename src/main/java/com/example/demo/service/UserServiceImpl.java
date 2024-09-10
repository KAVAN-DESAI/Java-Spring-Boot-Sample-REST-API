package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.config.RegsitrationProperties;
import com.example.demo.utils.request.RegistrationRequest;
import com.example.demo.utils.response.RegistrationResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private String message;
    private final RegsitrationProperties regsitrationProperties;

    @Autowired
    public void setMessage() {
        this.message = regsitrationProperties.getMessage();
    }

    public String makeResponseMessage(String name) {
        return String.format("%s %s", name, this.message);
    }

    @Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {
		log.info("{} registered successfully!", registrationRequest.getName());
        String registrationSuccessMessage = makeResponseMessage(registrationRequest.getName());

		return new RegistrationResponse(registrationSuccessMessage, HttpStatus.OK.toString());
    }
}
