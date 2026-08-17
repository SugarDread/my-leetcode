package com.sugardread.leetcodeapplication.service.impl;

import com.sugardread.leetcodeapplication.domain.entity.User;
import com.sugardread.leetcodeapplication.domain.enums.Role;
import com.sugardread.leetcodeapplication.exception.UserAlreadyExistsException;
import com.sugardread.leetcodeapplication.repository.UserRepository;
import com.sugardread.leetcodeapplication.security.CustomUserDetails;
import com.sugardread.leetcodeapplication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails login(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        return userDetailsService.loadUserByUsername(username);
    }

    @Override
    public UserDetails register(String username, String email, String password) {
        if (userRepository.existsByUsername(username) || userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("");
        }
        User user = userRepository.findByUsername(username).orElseGet(() -> {
            User newUser = User.builder()
                    .username(username)
                    .email(email)
                    .passwordHash(passwordEncoder.encode(password))
                    .enabled(true)
                    .role(Role.USER)
                    .createdAt(Instant.now())
                    .updatedAt(Instant.now())
                    .build();
            return userRepository.save(newUser);
        });
        return new CustomUserDetails(user);
    }
}
