package com.practice.speedrun.dto.response;

import lombok.Data;

@Data
public class JwtAuthResponse {
    private String token;
    private String type = "Bearer";

    public JwtAuthResponse(String accessToken) {
        this.token = accessToken;
    }
}
