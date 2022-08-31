package com.practice.speedrun.controller;

import com.practice.speedrun.dto.request.DeviceRequest;
import com.practice.speedrun.dto.response.DeviceResponse;
import com.practice.speedrun.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceControllerImpl implements DeviceController{

    private DeviceService deviceServiceImpl;

    public DeviceControllerImpl(DeviceService deviceServiceImpl) {
        this.deviceServiceImpl = deviceServiceImpl;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<DeviceResponse>> getAll() {
        return ResponseEntity.ok(deviceServiceImpl.getAll());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DeviceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceServiceImpl.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void create(@RequestBody @Valid DeviceRequest deviceRequest) {
        deviceServiceImpl.create(deviceRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void update(@RequestBody @Valid DeviceRequest deviceRequest,@PathVariable Long id) {
        deviceServiceImpl.update(deviceRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void delete(@PathVariable Long id) {
        deviceServiceImpl.delete(id);
    }
}
