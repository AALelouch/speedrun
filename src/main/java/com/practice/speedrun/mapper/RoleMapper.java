package com.practice.speedrun.mapper;

import com.practice.speedrun.dto.response.RoleResponse;
import com.practice.speedrun.model.Role;

public interface RoleMapper {
    RoleResponse toResponse(Role role);
}
