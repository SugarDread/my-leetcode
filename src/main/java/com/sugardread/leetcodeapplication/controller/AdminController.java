package com.sugardread.leetcodeapplication.controller;

import com.sugardread.leetcodeapplication.domain.dto.UserUpdateByAdmin;
import com.sugardread.leetcodeapplication.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final AdminService adminService;

    @PatchMapping("/block")
    public ResponseEntity<String> blockUser(@RequestBody UserUpdateByAdmin request) {
        adminService.changeUserEnable(request.getUsername(), false);
        return ResponseEntity.ok("User " + request.getUsername() + " was blocked");
    }
}
