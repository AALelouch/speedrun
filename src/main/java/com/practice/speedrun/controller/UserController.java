package com.practice.speedrun.controller;

import com.practice.speedrun.dto.request.UserRequest;
import com.practice.speedrun.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {

    ResponseEntity<List<UserResponse>> getAll();

    ResponseEntity<UserResponse> getByUsername(String username);

    ResponseEntity<UserResponse> getById(Long id);

    void create(UserRequest userRequest);

    void update(UserRequest userRequest, Long id);

    void delete(Long id);
}
