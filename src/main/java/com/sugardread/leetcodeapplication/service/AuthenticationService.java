package com.sugardread.leetcodeapplication.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails authenticate(String userName, String passwordHash);
    String generateToken(UserDetails userDetails);
    UserDetails validateToken(String token);
}
