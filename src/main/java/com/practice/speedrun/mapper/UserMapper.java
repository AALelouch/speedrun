package com.practice.speedrun.mapper;

import com.practice.speedrun.dto.request.UserRequest;
import com.practice.speedrun.dto.response.UserResponse;
import com.practice.speedrun.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toEntity(UserRequest userRequest);
    UserResponse toResponse(UserResponse userResponse);
}
