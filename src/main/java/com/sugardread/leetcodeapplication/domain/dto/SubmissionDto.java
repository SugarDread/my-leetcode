package com.sugardread.leetcodeapplication.domain.dto;

import com.sugardread.leetcodeapplication.domain.enums.ProgrammingLanguage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubmissionDto {
    @NotBlank
    private String problemSlug;

    @NotNull
    private ProgrammingLanguage language;

    @NotBlank
    private String sourceCode;
}
