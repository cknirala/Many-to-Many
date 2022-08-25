package com.example.ManytoMany.service;

import com.example.ManytoMany.entity.Course;
import com.example.ManytoMany.entity.Student;
import com.example.ManytoMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> findAllStudent(){

        return studentRepository.findAll();
    }

    public Student findOne(Long id) {

        return studentRepository.findById(id).orElse(null);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}