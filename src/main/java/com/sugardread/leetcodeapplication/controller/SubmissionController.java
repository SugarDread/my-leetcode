package com.sugardread.leetcodeapplication.controller;

import com.sugardread.leetcodeapplication.domain.dto.SubmissionDto;
import com.sugardread.leetcodeapplication.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/api/v1/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping()
    public ResponseEntity<SubmissionDto> submit(@RequestBody SubmissionDto submissionDto, Principal principal) {
        SubmissionDto createdSubmission = submissionService.submit(
                submissionDto,
                principal.getName()
        );
        return ResponseEntity.ok(createdSubmission);
    }

}
