package com.sugardread.leetcodeapplication.service.impl;

import com.sugardread.leetcodeapplication.domain.dto.SubmissionDto;
import com.sugardread.leetcodeapplication.domain.entity.Submission;
import com.sugardread.leetcodeapplication.domain.entity.User;
import com.sugardread.leetcodeapplication.domain.enums.SubmissionStatus;
import com.sugardread.leetcodeapplication.mapper.SubmissionMapper;
import com.sugardread.leetcodeapplication.repository.ProblemRepository;
import com.sugardread.leetcodeapplication.repository.SubmissionRepository;
import com.sugardread.leetcodeapplication.repository.UserRepository;
import com.sugardread.leetcodeapplication.service.SubmissionService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;
    private final SubmissionRepository submissionRepository;

    public SubmissionServiceImpl(UserRepository userRepository, ProblemRepository problemRepository, SubmissionRepository submissionRepository) {
        this.userRepository = userRepository;
        this.problemRepository = problemRepository;
        this.submissionRepository = submissionRepository;
    }

    @Override
    public SubmissionDto submit(SubmissionDto submissionDto, String username) {
        Submission submission = Submission.builder()
                .user(userRepository.findByUsername(username).orElseThrow())
                .problem(problemRepository.findProblemBySlug(submissionDto.getProblemSlug()).orElseThrow(
                        () -> new NoSuchElementException("Problem not found"))
                )
                .language(submissionDto.getLanguage())
                .sourceCode(submissionDto.getSourceCode())
                .submissionStatus(SubmissionStatus.PENDING)
                .createdAt(Instant.now())
                .build();
        return SubmissionMapper.toDto(submissionRepository.save(submission));
    }

    @Override
    public List<SubmissionDto> getAllSubmissionsByUser(String username) {
        List<Submission> submissions = submissionRepository.findAllByUser_Username(username);
        return submissions.stream()
                .map(SubmissionMapper::toDto)
                .toList();

    }
}
