package com.example.kurssi.controller;

import java.util.List;

import com.example.kurssi.data.Course;
import com.example.kurssi.data.Student;
import com.example.kurssi.service.CourseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KurssiController {
    private CourseService c = new CourseService();

    @GetMapping("/students")
    public List<Student> controllerGeStudents() {
        return c.getStudents();
    }

    @GetMapping("/courses")
    public List<Course> controllerGetCourses() {
        return c.getCourses();
    }

    @GetMapping("/students/{id}")
    public Student controllerGetStudentById(@PathVariable long id) {
        return c.getStudentById(id);
    }

    @GetMapping("/courses/{id}")
    public Course controllerGetCourseById(@PathVariable long id) {
        return c.getCourseById(id);
    }
}
