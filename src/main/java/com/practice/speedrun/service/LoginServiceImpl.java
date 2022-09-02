package com.practice.speedrun.service;

import com.practice.speedrun.dto.request.LoginRequest;
import com.practice.speedrun.dto.response.JwtAuthResponse;
import com.practice.speedrun.security.jwt.JtwTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JtwTokenProvider jwtTokenProvider;


    @Override
    public JwtAuthResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        return new JwtAuthResponse(jwt);
    }
}
