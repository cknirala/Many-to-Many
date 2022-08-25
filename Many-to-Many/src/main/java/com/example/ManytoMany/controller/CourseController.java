package com.example.ManytoMany.controller;

import com.example.ManytoMany.entity.Course;
import com.example.ManytoMany.entity.Student;
import com.example.ManytoMany.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    private Course save(@RequestBody Course course){

        return courseService.saveCourse(course);
    }

    @GetMapping
    private List<Course> findAll(){
        return courseService.findAllCourse();
    }
    @GetMapping("/{id}")
    private Course getCourseById(@PathVariable("id") long id) {
        return courseService.findOne(id);
    }
    @PutMapping("/{id}")
    private Course updateCourseById(@PathVariable Long id, @RequestBody Course course){
        course.setId(id);
        return courseService.update(course);
    }

    @DeleteMapping("/deletes/{id}")
    private void deleteCourseById(@PathVariable Long id){
        courseService.delete(id);
    }
}


