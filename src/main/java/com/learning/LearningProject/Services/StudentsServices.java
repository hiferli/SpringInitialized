package com.learning.LearningProject.Services;

import com.learning.LearningProject.Classes.Student;
import com.learning.LearningProject.DataRepositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsServices {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentsServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        return Arrays.asList(
//                new Student(1, "John", 20),
//                new Student(2, "Jacob", 21),
//                new Student(3, "Mark", 23)
//        );

        return studentRepository.findAll();
    }

    public void addStudent(Student newStudent){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(newStudent.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("The email is already registered");
        }

        studentRepository.save(newStudent);
    }

    public void deleteStudent(int studentId){
        boolean foundStudent = studentRepository.existsById(studentId);

        if(!foundStudent){
            throw new IllegalStateException("Student with id " + studentId + " not found");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(int studentId , Student updatedStudent){
        Student currentStudent = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " not found"));
        currentStudent.setAge(updatedStudent.getAge());
        currentStudent.setEmail(updatedStudent.getEmail());
        currentStudent.setName(updatedStudent.getName());
    }
}
