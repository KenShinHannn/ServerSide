package com.example.exam.services;

import com.example.exam.dtos.CreateAndUpdateStudentGradeDTO;
import com.example.exam.entities.Student;
import com.example.exam.entities.StudentGrade;
import com.example.exam.repositories.StudentGradeRepository;
import com.example.exam.repositories.StudentRepository;
import com.example.exam.repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentGradeService {
    @Autowired
    private StudentGradeRepository studentGradeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ModelMapper modelMapper;

    public StudentGrade addNewStudentGrade(Integer studentId, CreateAndUpdateStudentGradeDTO createStudentGradeDTO) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND , studentId + "studentId does exits!"));
        StudentGrade studentGrade = modelMapper.map(createStudentGradeDTO, StudentGrade.class);
        studentGrade.setStudent(student);
        return studentGradeRepository.saveAndFlush(studentGrade);
    }

    public void deleteStudentAllGradeBySubject(Integer studentId, Integer subjectId) {
        studentGradeRepository.delete(
                studentGradeRepository.findByStudentAndSubject(
                        studentRepository.findById(studentId).orElse(null), subjectRepository.findById(subjectId).
                                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, studentId + "or" + subjectId +
                                        "does not exits!"))
                )
        );
    }


}
