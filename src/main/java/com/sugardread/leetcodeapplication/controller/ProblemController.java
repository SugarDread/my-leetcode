package com.sugardread.leetcodeapplication.controller;

import com.sugardread.leetcodeapplication.domain.dto.ProblemDto;
import com.sugardread.leetcodeapplication.service.ProblemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/problems")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping()
    public ResponseEntity<List<ProblemDto>> getAllProblems() {
        List<ProblemDto> problems = problemService.getAllProblems();
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<ProblemDto>> getAllProblemsByCategory(@PathVariable String category) {
        List<ProblemDto> problems = problemService.getAllProblemsByCategory(category);
        return ResponseEntity.ok(problems);
    }

    @PostMapping("/create")
    public ResponseEntity<ProblemDto> createProblem(@Valid @RequestBody ProblemDto problemToCreate) {
        ProblemDto createdProblem = problemService.createProblem(problemToCreate);
        return ResponseEntity.created(URI.create("/api/v1/problems/" + createdProblem.getSlug())).body(createdProblem);

    }
}
