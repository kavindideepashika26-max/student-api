package com.example.student_api.controller;

import com.example.student_api.entity.Student;
import com.example.student_api.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    // Get all students
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
    return studentService.getStudentById(id);
}   
    // Update a student
    @PutMapping("/{id}")
    public Student updateStudent(
        @PathVariable Long id,
        @RequestBody Student student) {

    return studentService.updateStudent(id, student);
}

    // Delete a student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

    studentService.deleteStudent(id);

    return "Student deleted successfully";
}
    
    // Add a student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}