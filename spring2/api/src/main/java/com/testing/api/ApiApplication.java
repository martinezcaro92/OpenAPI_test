package com.testing.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
	title = "Students, teachers and schools management API", 
	version = "3.0", 
	termsOfService = "",
	description = "It is a testing API for school resources management (schools, teachers and students)")
)
public class ApiApplication {

	public List <Student> students = new ArrayList<>();
	public List <Teacher> teachers = new ArrayList<>();
	public List <SchoolHR> schoolData = new ArrayList<>();	
	
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
	public List<SchoolHR> getSchoolData() {
		return schoolData;
	}
	public void setSchoolData(List<SchoolHR> schoolData) {
		this.schoolData = schoolData;
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
