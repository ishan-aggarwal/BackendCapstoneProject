package com.ishan.jwttokenusingredis.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ValidateTokenRequestDto {
    String email;
    String token;
}
