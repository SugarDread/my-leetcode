package com.sugardread.leetcodeapplication.service;

import com.sugardread.leetcodeapplication.domain.dto.SubmissionDto;

import java.util.List;

public interface SubmissionService {
    SubmissionDto submit(SubmissionDto submissionDto, String username);
    List<SubmissionDto> getAllSubmissionsByUser(String username);
}
