package com.practice.speedrun.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DeviceRequest {
    @NotBlank(message = "Name can't be empty or null")
    private String name;

    @NotBlank(message = "RAM can't be empty or null")
    private String ram;

    @NotBlank(message = "SSD can't be empty or null")
    private String ssd;

    @NotBlank(message = "Image quality can't be empty or null")
    private String imageQuality;

    @NotBlank(message = "Brand can't be empty or null")
    private String brand;

    @NotBlank(message = "Processor can't be empty or null")
    private String processor;

    @NotBlank(message = "Graph can't be empty or null")
    private String graph;
}
