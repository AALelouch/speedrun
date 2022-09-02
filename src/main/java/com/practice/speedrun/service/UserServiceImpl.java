package com.practice.speedrun.service;

import com.practice.speedrun.dto.request.UserRequest;
import com.practice.speedrun.dto.response.UserResponse;
import com.practice.speedrun.exception.BadRequestException;
import com.practice.speedrun.exception.NotFoundException;
import com.practice.speedrun.mapper.UserMapper;
import com.practice.speedrun.model.User;
import com.practice.speedrun.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private UserMapper userMapper;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream().map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getByUsername(String username) {
        return userRepository.findByUsername(username).map(userMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public UserResponse getById(Long id) {
        return userRepository.findById(id).map(userMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public void create(UserRequest userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()).isPresent()){
            throw new BadRequestException("Username already exist");
        }

        User user = userMapper.toEntity(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        userRepository.save(user);
    }

    @Override
    public void update(UserRequest userRequest, Long id) {
        User user = userMapper.toEntity(userRequest);
        user.setId(id);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        if (userRepository.findById(id).isEmpty()){
            throw new NotFoundException("User not found");
        }

        userRepository.deleteById(id);
    }
}
