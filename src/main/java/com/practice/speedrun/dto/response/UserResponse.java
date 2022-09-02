package com.practice.speedrun.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;

    private List<String> roles;


}
