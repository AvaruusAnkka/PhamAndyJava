package com.example.kurssi.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.example.kurssi.data.Course;
import com.example.kurssi.data.Student;
import com.example.kurssi.data.courses.LocalCourse;
import com.example.kurssi.data.courses.OnlineCourse;

public class CourseService implements ICourseService {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public CourseService() {
        CourseFileService c = new CourseFileService();
        try {
            this.students = c.readStudentsFromFile("Students.txt");
            this.courses = c.readCoursesFromFile("Courses.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getStudents() {
        return this.students;
    }

    @Override
    public List<Course> getCourses() {
        return this.courses;
    }

    @Override
    public Student getStudentById(long studentId) {
        for (Student i : students) {
            if (i.getId() == studentId) return i;
        } 
        return null;
    }

    @Override
    public Course getCourseById(long courseId) {
        for (Course i : courses) {
            if (i.getId() == courseId) return i;
        }
        return null;
    }

    @Override
    public List<Course> getCoursesOfStudent(long studentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addStudentToCourse(long studentId, long courseId) {
        // TODO Auto-generated method stub
        return false;
    }
}
