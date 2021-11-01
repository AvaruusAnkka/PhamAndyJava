package com.example.kurssi.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    protected Long id;
    protected static long idCount = 0;
    protected String name;
    protected String teacher;
    private List<Student> attendees = new ArrayList<>(25);

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

    public boolean addStudent(Student student) {
        for (Student a : attendees) {
            if (a == student) return false;
        }
        attendees.add(student);
        return true;
    }

    public void removeStudent(Student student) {
        attendees.remove(student);
    }

    public List<Student> getAttendees() {
        return this.attendees;
    }

    @Override
    public String toString() {
        return getName() + " - " + getTeacher();
    }

    public long[] toArray() {
        return null;
    }
}
