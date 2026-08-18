package com.sugardread.leetcodeapplication.service.impl;

import com.sugardread.leetcodeapplication.domain.entity.User;
import com.sugardread.leetcodeapplication.domain.enums.Role;
import com.sugardread.leetcodeapplication.repository.UserRepository;
import com.sugardread.leetcodeapplication.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Override
    public void changeUserEnable(String username, boolean enable) {
        User user = userRepository.findByUsername(username).orElseThrow();
        user.setEnabled(enable);
        user.setUpdatedAt(Instant.now());
        userRepository.save(user);
    }

    @Override
    public void changeUserRole(String username, Role role) {
        User user = userRepository.findByUsername(username).orElseThrow();
        user.setRole(role);
        user.setUpdatedAt(Instant.now());
        userRepository.save(user);
    }
}
