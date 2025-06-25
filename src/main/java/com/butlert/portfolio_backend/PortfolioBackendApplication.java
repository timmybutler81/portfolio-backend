package com.butlert.portfolio_backend;

import com.butlert.portfolio_backend.model.Project;
import com.butlert.portfolio_backend.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PortfolioBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProjectRepository repo) {
		return args -> {
			System.out.println("Seeding sample projects...");

			repo.save(new Project(
					null,
					"Trading Card Manager",
					"JavaFX app to manage and track trading cards.",
					"https://github.com/Timothy/tradingcardmanager",
					"",
					List.of("Java", "JavaFX", "OOP")
			));

			repo.save(new Project(
					null,
					"Expense Tracker API",
					"Spring Boot API for managing personal expenses.",
					"https://github.com/Timothy/expense-tracker",
					"https://demo.example.com",
					List.of("Spring Boot", "REST API", "Budgeting")
			));
		};
	}
}
