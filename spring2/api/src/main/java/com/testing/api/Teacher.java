package com.testing.api;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class Teacher {
    @Schema(defaultValue = "1")
    private int id;
    @Schema(defaultValue = "Jose Manuel Martinez")
    private String name;
    @Schema(defaultValue = "30")
    private int age;
    @Schema(defaultValue = "jmmartinez@iesjuandelacierva.com")
    private String email;
    @Schema(defaultValue = "TICs")
    private String department;
    private List<String> courses = new ArrayList<>();

    public Teacher (){}

    public Teacher(int id, String name, int age, String email, String department, List<String> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

}
