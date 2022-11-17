package com.springdemo.testing;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>();

    public void addStudent(String firstName, String lastName, int id) {
        this.students.add(new Student(firstName, lastName, id));
    }

    @GetMapping(path = "/student")
    public Student setStudent(@Parameter(description = "Create a new Student with firstName and lastName", schema = @Schema) @Valid @RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName)
    {
        return new Student(firstName, lastName, 1);
    }

    @GetMapping("/student/list")
    public List<Student> getStudents()
    {
        return students;
    }
    
    @PostMapping(path = "/student")
    public ResponseEntity<Student> addStudent(@Parameter(description = "Add the attached student to the list", schema = @Schema) @Valid @RequestBody Student student) throws Exception
    {
        final Boolean studentExists = students.stream().anyMatch(st -> st.getId() == student.getId());
        if (studentExists == true) return new ResponseEntity("The student already exists in the list",HttpStatus.CONFLICT);
        this.students.add(student);
        if(students.isEmpty()) throw new Exception("Empty list after insert new entry");
        else return new ResponseEntity(students, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/student/")
    public ResponseEntity<Student> deleteStudent() throws Exception
    {
        if (students.isEmpty() == true) throw new Exception("The student list is empty");
        students = new ArrayList<>();
        return new ResponseEntity(students, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/student/{id}")
    public ResponseEntity<Student> deleteStudent(@Parameter(description = "Delete a Student by id", schema = @Schema) @Valid @PathVariable("id") int id) throws Exception
    { 
        Student st1 = students.stream().filter(currentStudent -> currentStudent.getId() == id)
            .findFirst().orElseThrow(()->new RuntimeException ("The user does not exist"));
        students.remove(st1);

        return ResponseEntity.ok().build();
    }

    /*
        @GetMapping("/student/{firstName}-{lastName}")
        public Student setStudent(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName)
        {
            return new Student(firstName, lastName);
        }
     */
}
