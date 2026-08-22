package com.sugardread.leetcodeapplication.mapper;

import com.sugardread.leetcodeapplication.domain.dto.SubmissionDto;
import com.sugardread.leetcodeapplication.domain.entity.Submission;
import org.springframework.stereotype.Component;

@Component
public final class SubmissionMapper {

    public static SubmissionDto toDto(Submission submission) {
        return SubmissionDto.builder()
                .problemSlug(submission.getProblem().getSlug())
                .language(submission.getLanguage())
                .sourceCode(submission.getSourceCode())
                .build();
    }

}
