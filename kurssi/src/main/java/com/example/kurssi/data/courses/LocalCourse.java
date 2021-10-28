package com.example.kurssi.data.courses;

import com.example.kurssi.data.Course;

public class LocalCourse extends Course {
    private String classroom;

    public LocalCourse(String name, String classroom) {
            this.name = name;
            this.classroom = classroom;
        }
    public String getClassroom() {
        return this.classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
