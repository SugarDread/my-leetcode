package com.sugardread.leetcodeapplication.domain.dto;

import com.sugardread.leetcodeapplication.domain.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemDto {

    private String title;
    private String slug;
    private Difficulty difficulty;
    private String description;
}
