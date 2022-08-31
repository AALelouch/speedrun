package com.practice.speedrun.mapper;

import com.practice.speedrun.dto.request.DeviceRequest;
import com.practice.speedrun.dto.response.DeviceResponse;
import com.practice.speedrun.model.Device;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    Device toEntity(DeviceRequest deviceRequest);
    DeviceResponse toResponse(Device device);
}
