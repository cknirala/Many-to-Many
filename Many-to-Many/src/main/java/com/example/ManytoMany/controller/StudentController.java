package com.example.ManytoMany.controller;

import com.example.ManytoMany.entity.Student;
import com.example.ManytoMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    private Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    private List<Student>findAll(){
        return studentService.findAllStudent();
    }
    @GetMapping("/{id}")
    private Student getStudentById(@PathVariable Long id) {
        return studentService.findOne(id);
    }
    @PutMapping("/{id}")
    private Student updateStudentById(@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        return studentService.update(student);
    }

    @DeleteMapping("/deletes/{id}")
    private void deleteStudentById(@PathVariable Long id){
          studentService.delete(id);
    }
}
