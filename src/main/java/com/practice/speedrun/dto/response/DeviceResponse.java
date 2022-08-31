package com.practice.speedrun.dto.response;

import lombok.Data;

@Data
public class DeviceResponse {

    private String name;
    private String ram;
    private String ssd;
    private String imageQuality;
    private String brand;
    private String processor;
    private String graph;
}
