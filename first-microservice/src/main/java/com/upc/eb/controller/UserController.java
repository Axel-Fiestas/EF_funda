package com.upc.eb.controller;

import com.upc.eb.dto.request.UserRequestDto;
import com.upc.eb.dto.response.UserResponseDto;
import com.upc.eb.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), org.springframework.http.HttpStatus.OK);
    }

    @Transactional()
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.createUser(userRequestDto), org.springframework.http.HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);
    }

}
