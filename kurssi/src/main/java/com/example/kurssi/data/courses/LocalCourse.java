package com.example.kurssi.data.courses;

import com.example.kurssi.data.Course;

public class LocalCourse extends Course {
    private String classroom;

    public LocalCourse(String name, String teacher, String classroom) {
        this.name = name;
        this.teacher = teacher;
        this.classroom = classroom;
        this.id = idCount++;
    }
    public String getClassroom() {
        return this.classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
