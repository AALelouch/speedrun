package com.practice.speedrun.mapper;

import com.practice.speedrun.dto.response.RoleResponse;
import com.practice.speedrun.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponse toResponse(Role role);
}
