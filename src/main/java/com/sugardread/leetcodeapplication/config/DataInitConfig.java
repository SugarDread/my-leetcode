package com.sugardread.leetcodeapplication.config;

import com.sugardread.leetcodeapplication.domain.entity.User;
import com.sugardread.leetcodeapplication.domain.enums.Role;
import com.sugardread.leetcodeapplication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@Configuration
@AllArgsConstructor
public class DataInitConfig {

    @Bean
    public CommandLineRunner initAdminUser(
            UserRepository userRepository,
            PasswordEncoder encoder,
            @Value("${admin.password}") String password
    ) {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {

                User admin = User.builder()
                        .username("admin")
                        .email("admin email")
                        .role(Role.ADMIN)
                        .createdAt(Instant.now())
                        .updatedAt(Instant.now())
                        .enabled(true)
                        .passwordHash(encoder.encode(password))
                        .build();
                userRepository.save(admin);
            }
        };
    }
}
