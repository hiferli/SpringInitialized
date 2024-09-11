package com.learning.LearningProject.Controllers;

import com.learning.LearningProject.Classes.Student;
import com.learning.LearningProject.Services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    StudentsServices studentsServices;

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentsServices.getStudents();
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student newStudent){
        studentsServices.addStudent(newStudent);
    }

    @DeleteMapping(path = "/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        studentsServices.deleteStudent(studentId);
    }

    @PutMapping("/updateStudent/{studentId}")
    public void updateStudent(@PathVariable("studentId") int studentId , @RequestBody Student updatedStudent){
        studentsServices.updateStudent(studentId , updatedStudent);
    }
}
