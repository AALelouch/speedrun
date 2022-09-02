package com.practice.speedrun.controller;

import com.practice.speedrun.dto.request.LoginRequest;
import com.practice.speedrun.dto.response.JwtAuthResponse;
import org.springframework.http.ResponseEntity;

public interface LoginController {
    ResponseEntity<JwtAuthResponse> login(LoginRequest loginRequest);
}
