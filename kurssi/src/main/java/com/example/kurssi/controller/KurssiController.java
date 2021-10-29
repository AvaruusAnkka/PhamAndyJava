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
    public String controllerGetStudentById(@PathVariable long id) {
        String s = c.getStudentById(id).toString();
        s += "\n" + (c.getCoursesOfStudent(id)).toString().replace("[", "").replaceAll("]", "").replace(", ", "\n");
        return s;
    }

    @GetMapping("/courses/{id}")
    public String controllerGetCourseById(@PathVariable long id) {
        String s = c.getCourseById(id).toString();
        s += c.getStudentsByCourse(id).toString().replace("[", "").replaceAll("]", "").replace(", ", "\n");
        return s;
    }

    @PostMapping("add")
    public String controllerAddStudentToCourse(@RequestBody Map<String, Object> jsonMapping) {
        Long studentId = Long.parseLong(jsonMapping.get("sid").toString());
        Long courseId = Long.parseLong(jsonMapping.get("cid").toString());

        if (c.addStudentToCourse(studentId, courseId) == true) {
            String student = (c.getStudentById(studentId)).toString();
            String course = (c.getCourseById(courseId)).toString();
            return student + " ---> " + course;
        }
        return "Error 1.";
    }
}
