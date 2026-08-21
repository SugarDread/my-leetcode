package com.sugardread.leetcodeapplication.domain.dto;

import com.sugardread.leetcodeapplication.domain.enums.Difficulty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemDto {

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    @Pattern(regexp = "[a-z0-9-]+")
    private String slug;

    @NotNull
    private Difficulty difficulty;

    @NotBlank
    private String description;

    @NotEmpty
    private Set<String> categorySlugs;
}
