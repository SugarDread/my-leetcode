package com.sugardread.leetcodeapplication.service;

import com.sugardread.leetcodeapplication.domain.enums.Role;

public interface AdminService {
    void changeUserEnable(String username, boolean enable);
    void changeUserRole(String username, Role role);
}
