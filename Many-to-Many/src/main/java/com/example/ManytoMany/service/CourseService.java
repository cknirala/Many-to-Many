package com.example.ManytoMany.service;

import com.example.ManytoMany.entity.Course;
import com.example.ManytoMany.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentService studentService;

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    public List<Course> findAllCourse(){

        return courseRepository.findAll();
    }

    public Course findOne(Long id) {

        return courseRepository.findById(id).orElse(null);
    }

    public Course update(Course course){
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}

