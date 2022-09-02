package com.practice.speedrun.service;

import com.practice.speedrun.dto.request.LoginRequest;
import com.practice.speedrun.dto.response.JwtAuthResponse;

public interface LoginService {
    public JwtAuthResponse login(LoginRequest loginRequest);
}
