package com.example.kurssi.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.kurssi.data.Course;
import com.example.kurssi.data.Student;

public interface ICourseFileService {
    
    List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException;

    List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException;
}
