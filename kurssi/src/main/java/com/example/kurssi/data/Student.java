package com.example.kurssi.data;

public class Student {
    private int id;
    private static int idCount = 0;
    private String fname;
    private String lname;

    public Student(String fname, String lname) {
        this.id = idCount++;
        this.fname = fname;
        this.lname = lname;
    }

    public int getId() {
        return this.id;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return getLname() + " " + getFname();
    }
}
