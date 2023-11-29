package com.upc.eb.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String lastName;
    private String email;
    private String password;
}
