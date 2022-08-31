package com.practice.speedrun.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank(message = "Username can't be empty or null")
    private String username;

    @NotBlank(message = "Password can't be empty or null")
    private String password;
}
