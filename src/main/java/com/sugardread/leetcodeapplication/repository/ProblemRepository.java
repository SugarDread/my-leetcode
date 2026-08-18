package com.sugardread.leetcodeapplication.repository;

import com.sugardread.leetcodeapplication.domain.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    @Query("SELECT p FROM Problem p LEFT JOIN FETCH p.categories")
    List<Problem> findAllWithCategories();

    @Query("SELECT p FROM Problem p " +
            "LEFT JOIN FETCH p.categories " +
            "WHERE p.id IN ( " +
                "SELECT p2.id FROM Problem p2 " +
                "JOIN p2.categories c " +
                "WHERE c.slug = :slug" +
            ")")
    List<Problem> findProblemsByCategory(@Param("slug") String slug);

}
