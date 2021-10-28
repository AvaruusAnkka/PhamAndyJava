package com.example.kurssi.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.kurssi.data.Course;
import com.example.kurssi.data.Student;
import com.example.kurssi.data.courses.LocalCourse;
import com.example.kurssi.data.courses.OnlineCourse;

public class CourseFileService implements ICourseFileService {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    @Override
    public List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException {
        try {
            FileInputStream f = new FileInputStream(filePath);
            DataInputStream d = new DataInputStream(f);
            BufferedReader b = new BufferedReader(new InputStreamReader(d));

            String text;
            while ((text = b.readLine()) != null) {
                String[] data = text.split(" ");
                this.students.add(new Student(data[0], data[1]));
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException {
        try {
            FileInputStream f = new FileInputStream(filePath);
            DataInputStream d = new DataInputStream(f);
            BufferedReader b = new BufferedReader(new InputStreamReader(d));

            String text;
            while ((text = b.readLine()) != null) {
                String[] data = text.split("--");
                if (data.length == 4) this.courses.add(new OnlineCourse(data[0], data[1], data[2]));
                else this.courses.add(new LocalCourse(data[0], data[1], data[2]));
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
