package com.practice.speedrun.service;

import com.practice.speedrun.dto.request.UserRequest;
import com.practice.speedrun.dto.response.UserResponse;
import com.practice.speedrun.model.User;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();

    UserResponse getByUsername(String username);

    UserResponse getById(Long id);

    void create(UserRequest userRequest);

    void update(UserRequest userRequest, Long id);

    void delete(Long id);

}
