package com.sugardread.leetcodeapplication.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token);
    String extractUsername(String token);
    String extractToken(HttpServletRequest request);
}
