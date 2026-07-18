package com.example.student_api.service;

import com.example.student_api.entity.Student;
import com.example.student_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    //update student
    public Student getStudentById(Long id) {
    return studentRepository.findById(id).orElse(null);
}
    // Update student
    public Student updateStudent(Long id, Student studentDetails) {

    Student student = studentRepository.findById(id).orElse(null);

    if (student != null) {
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());

        return studentRepository.save(student);
    }

    return null;
}
   
    // Delete student
    public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
}
    // Add student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}