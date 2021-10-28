package com.example.kurssi.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.kurssi.data.Course;
import com.example.kurssi.data.Student; 

public interface ICourseService {
    
    List<Student> getStudents();

    List<Course> getCourses();

    Student getStudentById(long studentId);

    Course getCourseById(long courseId);

    List<Course> getCoursesOfStudent(long studentId);

    boolean addStudentToCourse(long studentId, long courseId);

    List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException;

    List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException;
}
