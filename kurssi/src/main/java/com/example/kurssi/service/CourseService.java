package com.example.kurssi.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.kurssi.data.Course;
import com.example.kurssi.data.Student;

public class CourseService implements ICourseService {

    public CourseService() {
        
    }

    @Override
    public List<Student> getStudents() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Course> getCourses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Student getStudentById(long studentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Course getCourseById(long courseId) {
        // TODO Auto-generated method stub
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

    @Override
    public List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
