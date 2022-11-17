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
@RequestMapping("/teacher")
@Tag(name = "2. Teacher Management", description = "Everything to contol the teachers")
public class TeacherController {
    /**
     *
     */
    private List <Teacher> teachers = new ArrayList<>();


    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Default Teacher information * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Operation(summary = "Return a default teacher", description="Return a default teacher")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping()
    public ResponseEntity<Object> getDefaultTeacher()
    {
        List <String> courses = new ArrayList<>();
        courses.add("1B"); courses.add("2A"); courses.add("3C");
        Teacher teacher = new Teacher(11, "Isabel Romero", 23, "isaaRomero@gmail.com",courses, "TICs", SchoolRole.TEACHER);
        return ResponseEntity.ok(teacher);
    }
    
    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Return the teacher list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    @Operation(summary = "Return the teacher list", description="Return the teacher list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping(path = "/list")
    public ResponseEntity<Object> getAllTeachers()
    {
        return ResponseEntity.ok(this.teachers);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Delete the student list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    @Operation(summary = "Delete the teacher list", description="Delete the teacher list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @DeleteMapping(path = "/list")
    public ResponseEntity<Object> deleteAllTeachers()
    {
        this.teachers = new ArrayList<>();
        return ResponseEntity.ok(this.teachers);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Modify the teacher information * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    @Operation(summary = "Attach the default teacher in the list", description="Attach the default teacher in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> putEditIdTeacher(@PathVariable("id") int id, @RequestBody Teacher teacher)
    {
        final int st1 = IntStream.range(0, teachers.size()).filter(i->teachers.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new ErrorResponse("ID does not exists", HttpStatus.BAD_REQUEST.value()));
        teachers.remove(st1);
        teachers.add(teacher);
        return ResponseEntity.ok().body(teachers);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Add to the list a teacher * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    @Operation(summary = "Attach the new teacher in the list", description="Attach the new teacher in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    
    @PostMapping()
    public ResponseEntity<Object> postNewTeacher(@RequestBody Teacher teacher)
    {
        final Boolean teacherExists = teachers.stream().anyMatch(st -> st.getId() == teacher.getId());
        if (teacherExists) return ResponseEntity.badRequest().body(new ErrorResponse("The teacher (id) already exiss in the list", HttpStatus.BAD_REQUEST.value()));
        teachers.add(teacher);
        return ResponseEntity.ok().body(teacher);
    }
}
