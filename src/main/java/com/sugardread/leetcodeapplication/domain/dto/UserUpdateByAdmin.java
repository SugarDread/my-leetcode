package com.sugardread.leetcodeapplication.domain.dto;

import com.sugardread.leetcodeapplication.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateByAdmin {
    private String username;
    private String email;
    private Role role;
    private boolean enable;
}
