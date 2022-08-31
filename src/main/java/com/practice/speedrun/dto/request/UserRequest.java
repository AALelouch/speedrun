package com.practice.speedrun.dto.request;

import com.practice.speedrun.model.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class UserRequest {

    @NotBlank(message = "Name can't be empty or null")
    private String name;

    @NotBlank(message = "Surname can't be empty or null")
    private String surname;

    @NotBlank(message = "Username can't be empty or null")
    private String username;

    @NotBlank(message = "Password can't be empty or null")
    private String password;

    @NotBlank(message = "Email can't be empty or null")
    private String email;

    @NotBlank(message = "Roles can't be empty or null")
    private Set<Role> roles = new HashSet<>();
}
