package com.upc.eb.service.interf;

import com.upc.eb.dto.request.UserRequestDto;
import com.upc.eb.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto modifyUser(Long userId, UserRequestDto userRequestDto);

    void deleteUser(Long userId);
}
