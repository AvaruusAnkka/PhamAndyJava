package com.example.kurssi.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    protected Long id;
    protected long idCount = 0;
    protected String name;
    private String teacher;
    private int limit = 25;
    private List<Student> attendees = new ArrayList<>();

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        if (attendees.size() < limit) attendees.add(student);
    }

    public void removeStudent(Student student) {
        attendees.remove(student);
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Student> getAttendees() {
        return this.attendees;
    }

    @Override
    public String toString() {
        return getName() + " - " + getTeacher();
    }
}
