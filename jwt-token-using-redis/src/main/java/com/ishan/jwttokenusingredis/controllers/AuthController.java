package com.ishan.jwttokenusingredis.controllers;

import com.ishan.jwttokenusingredis.dtos.LoginRequestDto;
import com.ishan.jwttokenusingredis.dtos.ValidateTokenRequestDto;
import com.ishan.jwttokenusingredis.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
    }

    @PostMapping("/validateToken")
    public Boolean validateToken(@RequestBody ValidateTokenRequestDto validateTokenRequestDto) {
        return authenticationService.validateToken(validateTokenRequestDto.getEmail(), validateTokenRequestDto.getToken());
    }
}
