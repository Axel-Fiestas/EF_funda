package com.upc.eb.service.impl;

import com.upc.eb.dto.request.UserRequestDto;
import com.upc.eb.dto.response.UserResponseDto;
import com.upc.eb.model.User;
import com.upc.eb.repository.UserRepository;
import com.upc.eb.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserResponseDto convertToDto(User user) {
        UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
        return userResponseDto;
    }

    public User convertToEntity(UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        return user;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDto).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = convertToEntity(userRequestDto);
        User userCreated = userRepository.save(user);
        return convertToDto(userCreated);
    }

    @Override
    public UserResponseDto modifyUser(Long userId, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
