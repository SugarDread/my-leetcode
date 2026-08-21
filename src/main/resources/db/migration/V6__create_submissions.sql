CREATE TABLE submissions (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    problem_id BIGINT NOT NULL,
    language VARCHAR(30) NOT NULL,
    source_code TEXT NOT NULL,
    status VARCHAR(30) NOT NULL,
    runtime_ms INTEGER,
    memory_kb INTEGER,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT fk_submissions_users
        FOREIGN KEY (user_id)
        REFERENCES users(id),
    CONSTRAINT fk_submissions_problems
        FOREIGN KEY (problem_id)
        REFERENCES problems(id)
);