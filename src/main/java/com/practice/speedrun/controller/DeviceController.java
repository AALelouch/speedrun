package com.practice.speedrun.controller;

import com.practice.speedrun.dto.request.DeviceRequest;
import com.practice.speedrun.dto.response.DeviceResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeviceController {
    ResponseEntity<List<DeviceResponse>> getAll();
    ResponseEntity<DeviceResponse> getById(Long id);
    void create(DeviceRequest deviceRequest);
    void update(DeviceRequest deviceRequest, Long id);
    void delete(Long id);

}
