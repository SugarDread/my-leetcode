package com.sugardread.leetcodeapplication.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails login(String username, String password);
    UserDetails register(String username, String email, String password);
}
