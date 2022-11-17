package com.testing.api;

import io.swagger.v3.oas.annotations.media.Schema;

public class SchoolHR {
    @Schema(defaultValue = "1")
    private int id;
    @Schema(defaultValue = "María")
    private String name;
    @Schema(defaultValue = "25")
    private int age;
    @Schema(defaultValue = "mariaaRo@gmail.com")
    private String email;
    ///@Schema(defaultValue = "STUDENT")
    private SchoolRole schoolRole;

    public SchoolHR() {}

    public SchoolHR(int id, String name, int age, String email, SchoolRole schoolRole) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.schoolRole = schoolRole;
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
    public SchoolRole getSchoolRole() {
        return schoolRole;
    }
    public void setSchoolRole(SchoolRole schoolRole) {
        this.schoolRole = schoolRole;
    }
}
