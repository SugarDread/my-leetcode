package com.sugardread.leetcodeapplication.controller;

import com.sugardread.leetcodeapplication.domain.dto.ProblemDto;
import com.sugardread.leetcodeapplication.domain.enums.Difficulty;
import com.sugardread.leetcodeapplication.service.JwtService;
import com.sugardread.leetcodeapplication.service.ProblemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProblemController.class)
public class ProblemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private JwtService jwtService;

    @MockitoBean
    private UserDetailsService userDetailsService;

    @MockitoBean
    private ProblemService problemService;

    List<ProblemDto> problems = new ArrayList<>();

    @BeforeEach
    void setUp() {
        problems = List.of(
                ProblemDto.builder()
                        .title("two sum")
                        .slug("two-sum")
                        .difficulty(Difficulty.EASY)
                        .description("problem two sum description")
                        .categorySlugs(Set.of("array", "math"))
                        .build(),
                ProblemDto.builder()
                        .title("add two numbers")
                        .slug("add-two-numbers")
                        .difficulty(Difficulty.MEDIUM)
                        .description("problem add two numbers description")
                        .categorySlugs(Set.of("linked-list", "math"))
                        .build()
        );
    }

    @Test
    @WithMockUser(roles = "USER")
    void shouldGetAllProblems() throws Exception {
        when(problemService.getAllProblems())
                .thenReturn(problems);

        mockMvc.perform(get("/api/v1/problems"))
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(ProblemController.class))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(problems.size()));

        verify(problemService).getAllProblems();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldCreateProblem() throws Exception {
        ProblemDto problemDto = ProblemDto.builder()
                .title("new problem")
                .slug("new-problem")
                .difficulty(Difficulty.HARD)
                .description("fdfdf")
                .categorySlugs(Set.of("fdfdfd"))
                .build();

        when(problemService.createProblem(problemDto))
                .thenReturn(problemDto);

        mockMvc.perform(
                post("/api/v1/problems/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(problemDto))
                        .with(csrf())
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value(problemDto.getTitle()))
                .andExpect(jsonPath("$.difficulty").value(problemDto.getDifficulty().toString()));

    }

    @Test
    @WithMockUser(roles = "USER")
    void shouldGetProblemsByCategory() throws Exception {
        String categorySlug = "array";

        when(problemService.getAllProblemsByCategory(categorySlug))
                .thenReturn(problems.stream()
                        .filter(problemDto -> problemDto.getCategorySlugs().contains(categorySlug))
                        .toList());

        mockMvc.perform(get("/api/v1/problems/" + categorySlug))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));
    }
}
