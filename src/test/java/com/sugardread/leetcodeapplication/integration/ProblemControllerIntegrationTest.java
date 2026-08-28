package com.sugardread.leetcodeapplication.integration;

import com.sugardread.leetcodeapplication.domain.entity.Category;
import com.sugardread.leetcodeapplication.domain.enums.Difficulty;
import com.sugardread.leetcodeapplication.repository.CategoryRepository;
import com.sugardread.leetcodeapplication.repository.ProblemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProblemControllerIntegrationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:17-alpine");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUpCategoryRepository() {
        categoryRepository.save(Category.builder()
                .name("hash table")
                .slug("hash-table")
                .build());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldCreateProblem() throws Exception {
        String json = """
                    {
                        "title": "two sum",
                        "slug": "two-sum",
                        "difficulty": "EASY",
                        "description": "task about two sum",
                        "categorySlugs": [
                            "hash-table"
                        ]
                    }
                """;

        mockMvc.perform(
                post("/api/v1/problems/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("two sum"))
                .andExpect(jsonPath("$.difficulty").value(Difficulty.EASY.toString()));

        assertThat(problemRepository.findAll())
                .hasSize(1);
    }

}
