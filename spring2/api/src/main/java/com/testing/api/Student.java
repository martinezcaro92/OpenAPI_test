package com.testing.api;

import io.swagger.v3.oas.annotations.media.Schema;

public class Student{

    @Schema(defaultValue = "1")
    private int id;
    @Schema(defaultValue = "María Salas")
    private String name;
    @Schema(defaultValue = "16")
    private int age;
    @Schema(defaultValue = "msalas@iesjuandelacierva.com")
    private String email;
    @Schema(defaultValue = "1CC")
    private String course;

    public Student(){}

    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
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


    public String getCourse() {
        return course;
    }


    public void setCourse(String course) {
        this.course = course;
    }
}
