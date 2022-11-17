package com.testing.api;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

public class SchoolHR {
    @Schema(defaultValue = "1")
    private int id;
    @Schema(defaultValue = "IES Juan de la Cierva")
    private String name;
    @Schema(defaultValue = "info@iesjuandelacierva.com")
    private String email;
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public SchoolHR() {}

    public SchoolHR(int id, String name,  String email, Student student, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.email = email;
        if (teacher != null) this.students.add(student);
        if (student != null) this.teachers.add(teacher); 
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
