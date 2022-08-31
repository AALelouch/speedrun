package com.practice.speedrun.service;

import com.practice.speedrun.dto.request.DeviceRequest;
import com.practice.speedrun.dto.response.DeviceResponse;
import com.practice.speedrun.exception.NotFoundException;
import com.practice.speedrun.mapper.DeviceMapper;
import com.practice.speedrun.model.Device;
import com.practice.speedrun.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {
    private DeviceRepository deviceRepository;
    private DeviceMapper deviceMapper;

    public DeviceServiceImpl(DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    @Override
    public List<DeviceResponse> getAll() {
        return deviceRepository.findAll().stream().map(deviceMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DeviceResponse getById(Long id) {
        return deviceMapper.toResponse(deviceRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Device not found")
        ));
    }

    @Override
    public void create(DeviceRequest deviceRequest) {
        deviceRepository.save(deviceMapper.toEntity(deviceRequest));
    }

    @Override
    public void update(DeviceRequest deviceRequest, Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Device not found")
        );

        device.setId(id);

        deviceRepository.save(device);
    }

    @Override
    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
