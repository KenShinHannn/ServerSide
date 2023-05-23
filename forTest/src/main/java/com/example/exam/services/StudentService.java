package com.example.exam.services;

import com.example.exam.entities.Student;
import com.example.exam.entities.StudentGrade;
import com.example.exam.repositories.StudentGradeRepository;
import com.example.exam.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public List<StudentGrade> getAllGradeFromStudentId(Integer studentId){
        return studentRepository.findById(studentId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getGrades();
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
}
