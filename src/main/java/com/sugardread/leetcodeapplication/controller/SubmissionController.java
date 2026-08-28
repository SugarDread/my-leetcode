package com.sugardread.leetcodeapplication.controller;

import com.sugardread.leetcodeapplication.domain.dto.SubmissionDto;
import com.sugardread.leetcodeapplication.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/submit")
    public ResponseEntity<SubmissionDto> submit(@RequestBody SubmissionDto submissionDto, Principal principal) {
        SubmissionDto createdSubmission = submissionService.submit(
                submissionDto,
                principal.getName()
        );
        return ResponseEntity.ok(createdSubmission);
    }

    @GetMapping
    public ResponseEntity<List<SubmissionDto>> getUserSubmissions(Principal principal) {
        List<SubmissionDto> submissions = submissionService.getAllSubmissionsByUser(principal.getName());

        return ResponseEntity.ok(submissions);
    }
}
