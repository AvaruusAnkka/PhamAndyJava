package com.example.kurssi.controller;

import java.util.List;
import java.util.Map;

import com.example.kurssi.data.Course;
import com.example.kurssi.data.Student;
import com.example.kurssi.service.CourseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @GetMapping("/onlinecourses")
    public String controllerGetOnlineCourses() {
        return c.getOnlineCourses();
    }

    @GetMapping("/students/{id}")
    public Student controllerGetStudentById(@PathVariable long id) {
        return c.getStudentById(id);
    }

    @GetMapping("/courses/{id}")
    public Course controllerGetCourseById(@PathVariable long id) {
        return c.getCourseById(id);
    }

    @PostMapping("add")
    public String controllerAddStudentToCourse(@RequestBody Map<String, Object> jsonMapping) {
        Long studentId = Long.parseLong(jsonMapping.get("sid").toString());
        Long courseId = Long.parseLong(jsonMapping.get("cid").toString());

        if (c.addStudentToCourse(studentId, courseId) == true) {
            String student = (c.findStudent(studentId)).toString();
            String course = (c.findCourse(courseId)).toString();
            return student + " ---> " + course;
        }
        return "Error 1.";
    }
}
