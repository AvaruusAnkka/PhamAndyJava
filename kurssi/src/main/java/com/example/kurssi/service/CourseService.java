package com.example.kurssi.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.example.kurssi.data.Course;
import com.example.kurssi.data.Student;

public class CourseService implements ICourseService {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public CourseService() {
        CourseFileService c = new CourseFileService();
        try {
            this.students = c.readStudentsFromFile("kurssi\\src\\main\\java\\com\\example\\kurssi\\data\\Students.txt");
            this.courses = c.readCoursesFromFile("kurssi\\src\\main\\java\\com\\example\\kurssi\\data\\Courses.txt");
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

    public String getOnlineCourses() {
        String onlineCourses = "";
        for (Course c : courses) {
            String[] data = c.toString().split(" - ");
            if (data.length == 3) {
                onlineCourses += c.getName() + ",";
            }
        }
        return onlineCourses;
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
    public boolean addStudentToCourse(long studentId, long courseId) {
        
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);

        if (student != null && course != null) {
            course.addStudent(student);
            return true;
        }
        return false;
    }

    @Override
    public List<Course> getCoursesOfStudent(long studentId) {
        List<Course> studentList = new ArrayList<>();
        for (Course c : courses) {
            List<Student> list = c.getAttendees();
            for (Student s : list) {
                if (s.getId() == studentId) studentList.add(c);
            }
        }
        return studentList;
    }

    public List<Student> getStudentsByCourse(long courseId) {
        for (Course c : courses) {
            if (c.getId() == courseId) return c.getAttendees();
        }
        return null;
    }
}
