package com.sugardread.leetcodeapplication.controller;

import com.sugardread.leetcodeapplication.domain.dto.LoginRequest;
import com.sugardread.leetcodeapplication.domain.dto.AuthResponse;
import com.sugardread.leetcodeapplication.service.JwtService;
import com.sugardread.leetcodeapplication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authenticationService.login(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        String tokenValue = jwtService.generateToken(userDetails);
        AuthResponse authResponse = AuthResponse.builder()
                .token(tokenValue)
                .expiresIn(86400)
                .build();
        return ResponseEntity.ok(authResponse);

    }

}
