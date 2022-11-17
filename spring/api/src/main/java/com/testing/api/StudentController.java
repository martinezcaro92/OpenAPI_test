package com.testing.api;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/student")
@Tag(name = "1. Student Management", description = "Everything to contol the students")
public class StudentController {
    /**
     *
     */
    private List <Student> students = new ArrayList<>();


    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Default Student information * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Operation(summary = "Return a default student", description="Return a default student")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping()
    public ResponseEntity<Object> getDefaultStudent()
    {
        Student student = new Student(30, "Isabel", 82, "pepeElTren@gmail.com",1, "B", SchoolRole.STUDENT);
        return ResponseEntity.ok(student);
    }
    
    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Return the student list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    @Operation(summary = "Return the student list", description="Return the student list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping(path = "/list")
    public ResponseEntity<Object> getAllStudents()
    {
        return ResponseEntity.ok(this.students);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Delete the student list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    @Operation(summary = "Delete the student list", description="Delete the student list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @DeleteMapping(path = "/list")
    public ResponseEntity<Object> deleteAllStudents()
    {
        this.students = new ArrayList<>();
        return ResponseEntity.ok(this.students);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Modify the student information * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    @Operation(summary = "Attach the default student in the list", description="Attach the default student in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> putEditIdStudent(@PathVariable("id") int id, @RequestBody Student student)
    {
        final int st1 = IntStream.range(0, students.size()).filter(i->students.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new ErrorResponse("ID does not exists", HttpStatus.BAD_REQUEST.value()));
        students.remove(st1);
        students.add(student);
        return ResponseEntity.ok().body(students);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Add to the list a student * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    @Operation(summary = "Attach the new student in the list", description="Attach the new student in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    
    @PostMapping()
    public ResponseEntity<Object> postNewStudent(@RequestBody Student student)
    {
        final Boolean studentExists = students.stream().anyMatch(st -> st.getId() == student.getId());
        if (studentExists) return ResponseEntity.badRequest().body(new ErrorResponse("The student (id) already exiss in the list", HttpStatus.BAD_REQUEST.value()));
        students.add(student);
        return ResponseEntity.ok().body(student);
    }
}
