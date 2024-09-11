package com.learning.LearningProject.Configs;

import com.learning.LearningProject.Classes.Student;
import com.learning.LearningProject.DataRepositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfigs {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student Ishaan = new Student("Ishaan" , 23 , "joshi.ishaan.2001@gmail.com");
            Student Ayush = new Student("Ayush" , 21 , "ayush.sharma@gmail.com");
            Student Mayank = new Student("Mayank" , 22 , "mayank.sharma@gmail.com");

            studentRepository.saveAll(List.of(Ishaan , Ayush , Mayank));
        };
    }
}
