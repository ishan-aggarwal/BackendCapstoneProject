package com.ishan.jwttokenusingredis.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {
    String email;
    String password;
}
