package com.example.kurssi.data.courses;

import com.example.kurssi.data.Course;

public class OnlineCourse extends Course {
    private String website;

    public OnlineCourse(String name, String website) {
        this.name = name;
        this.website = website;
        this.id = idCount++;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return getName() + " - " + getTeacher() + " - " + getWebsite();
    }
}
