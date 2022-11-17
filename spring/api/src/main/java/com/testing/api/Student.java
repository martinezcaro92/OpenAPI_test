package com.testing.api;

import io.swagger.v3.oas.annotations.media.Schema;

public class Student extends SchoolHR{
    @Schema(defaultValue = "3")
    private int course;
    @Schema(defaultValue = "B")
    private String group;
    @Schema(defaultValue = "STUDENT")
    private SchoolRole schoolRole;

    public Student(){}

    public Student(int id, String name, int age, String email, int course, String group, SchoolRole schoolRole) {
        super(id, name, age, email, schoolRole);
        this.course = course;
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
