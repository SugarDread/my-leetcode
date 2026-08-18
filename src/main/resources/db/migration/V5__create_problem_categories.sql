CREATE TABLE problem_categories (
    problem_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (problem_id, category_id),
    CONSTRAINT fk_problem_category_problem
        FOREIGN KEY (problem_id)
        REFERENCES problems(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_problem_category_category
        FOREIGN KEY (category_id)
        REFERENCES categories(id)
        ON DELETE CASCADE
);