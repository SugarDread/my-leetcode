package com.sugardread.leetcodeapplication.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestCaseDto {

    @NotBlank
    private String problemSlug;

    @NotBlank
    private String input;

    @NotBlank
    private String expectedOutput;

    private boolean isSample;
}
