package com.sprintBoot.Tutorial1.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentReporsitory repository){
        return args -> {
            Student hasindu = new Student(
                    "Hasindu",
                    "hasindukarunathilaka343@gmail.com",
                    LocalDate.of(1999, Month.SEPTEMBER,6)

            );

            Student lasindu = new Student(
                    "Lasindu",
                    "lasindu@gmail.com",
                    LocalDate.of(2000, Month.FEBRUARY,15)
            );
            repository.saveAll(
                    List.of(hasindu,lasindu)
            );
        };
    }
}
