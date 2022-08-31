package com.practice.speedrun.service;

import com.practice.speedrun.dto.request.DeviceRequest;
import com.practice.speedrun.dto.response.DeviceResponse;

import java.util.List;

public interface DeviceService {

    List<DeviceResponse> getAll();
    DeviceResponse getById(Long id);
    void create(DeviceRequest deviceRequest);
    void update(DeviceRequest deviceRequest, Long id);
    void delete(Long id);
}
