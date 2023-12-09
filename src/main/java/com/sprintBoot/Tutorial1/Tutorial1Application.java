package com.sprintBoot.Tutorial1;

import com.sprintBoot.Tutorial1.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication

@RestController
public class Tutorial1Application {
	public static void main(String[] args) {
		SpringApplication.run(Tutorial1Application.class, args);
	}

}
