package com.practice.speedrun.mapper;

import com.practice.speedrun.dto.request.UserRequest;
import com.practice.speedrun.dto.response.UserResponse;
import com.practice.speedrun.exception.NotFoundException;
import com.practice.speedrun.model.Role;
import com.practice.speedrun.model.User;
import com.practice.speedrun.repository.RoleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected RoleRepository roleRepository;

    protected Function<UserRequest, Set<Role>> mapRolesToEntity = userRequest ->
            userRequest.getRoles().stream().map(
                    roleName -> roleRepository.findByName(roleName).orElseThrow(
                            () -> new NotFoundException("Role not found")
                    )
            ).collect(Collectors.toSet());

    protected Function<User, List<String>> mapRolesToResponse = user ->
            user.getRoles().stream().map(Role::getName).collect(Collectors.toList());



    @Mapping(
            target = "roles",
            expression = "java(mapRolesToEntity.apply(userRequest))"
    )
    public abstract User toEntity(UserRequest userRequest);

    @Mapping(
            target = "roles",
            expression = "java(mapRolesToResponse.apply(user))"
    )
    public abstract UserResponse toResponse(User user);
}
