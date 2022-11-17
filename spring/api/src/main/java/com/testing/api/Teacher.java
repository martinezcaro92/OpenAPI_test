package com.testing.api;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class Teacher extends SchoolHR {
    private List<String> courses = new ArrayList<>();
    @Schema(defaultValue = "TICs")
    private String department;
    @Schema(defaultValue = "TEACHER")
    private SchoolRole schoolRole;


    public Teacher (){}

    public Teacher(int id, String name, int age, String email, List<String> courses, String department, SchoolRole schoolRole) {
        super(id, name, age, email, schoolRole);
        this.courses = courses;
        this.department = department;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
