package com.practice.speedrun.controller;

import com.practice.speedrun.dto.request.LoginRequest;
import com.practice.speedrun.dto.response.JwtAuthResponse;
import com.practice.speedrun.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class LoginControllerImpl implements LoginController{

    private LoginService loginServiceImpl;

    public LoginControllerImpl(LoginService loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }

    @Override
    @PostMapping
    public ResponseEntity<JwtAuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(loginServiceImpl.login(loginRequest));
    }
}
