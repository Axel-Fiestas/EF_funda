package com.upc.eb.dto.response;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
}
