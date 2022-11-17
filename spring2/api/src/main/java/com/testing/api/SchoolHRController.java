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
@RequestMapping()
public class SchoolHRController {

    public List<SchoolHR> schoolData = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    /* * * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * * * * * * SCHOOL * * * * * * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    
    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Return the school list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "School Management", description = "Everything to contol the school HR")
    @Operation(summary = "Return the school data", description="Return the school data")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolHR.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @GetMapping(path = "/school/list")
    public ResponseEntity<Object> getAllSchoolData()
    {
        return ResponseEntity.ok(this.schoolData);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Delete the school data list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "School Management", description = "Everything to contol the school HR")
    @Operation(summary = "Delete the school data", description="Delete the school data")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolHR.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @DeleteMapping(path = "/school/list")
    public ResponseEntity<Object> deleteAllSchoolData()
    {
        this.schoolData = new ArrayList<>();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        return ResponseEntity.ok(this.schoolData);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Modify the school information * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "School Management", description = "Everything to contol the school HR")
    @Operation(summary = "Modify the school data", description="Modify the school data")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolHR.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @PutMapping(path = "/school/{id}")
    public ResponseEntity<Object> putEditSchool(@PathVariable("id") int id, @RequestBody SchoolHR schoolInfo)
    {
        final int st1 = IntStream.range(0, this.schoolData.size()).filter(i->schoolData.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The School ID (" + id + ") does not exists", HttpStatus.BAD_REQUEST.value()));
        this.schoolData.remove(st1);
        this.schoolData.add(schoolInfo);
        return ResponseEntity.ok().body(this.schoolData);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * Return the school information by ID * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "School Management", description = "Everything to contol the school HR")
    @Operation(summary = "Return the school data by ID", description="Return the school data by ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolHR.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @GetMapping(path = "/school/{id}")
    public ResponseEntity<Object> getSchoolById(@PathVariable("id") int id)
    {
        final int st1 = IntStream.range(0, this.schoolData.size()).filter(i->schoolData.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The School ID (" + id + ") does not exists", HttpStatus.BAD_REQUEST.value()));
        return ResponseEntity.ok().body(this.schoolData.get(st1));
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * Delete the school information by ID * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "School Management", description = "Everything to contol the school HR")
    @Operation(summary = "Delete the school data by ID", description="Delete the school data by ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @DeleteMapping(path = "/school/{id}")
    public ResponseEntity<Object> deleteSchoolById(@PathVariable("id") int id)
    {
        final int st1 = IntStream.range(0, this.schoolData.size()).filter(i->schoolData.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The School ID (" + id + ") does not exists", HttpStatus.BAD_REQUEST.value()));
        this.schoolData.remove(st1);
        return ResponseEntity.ok().body(new TextResponse("The school ("+ id +") has been successfully deleted", HttpStatus.ACCEPTED.value()));
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Add to the list a school * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "School Management", description = "Everything to contol the school HR")
    @Operation(summary = "Attach the new school in the list", description="Attach the new school in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolHR.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    
    @PostMapping(path = "/school")
    public ResponseEntity<Object> postNewSchool(@RequestBody SchoolHR schoolInfo)
    {
        final Boolean schoolExists = this.schoolData.stream().anyMatch(st -> st.getId() == schoolInfo.getId());
        if (schoolExists) return ResponseEntity.badRequest().body(new TextResponse("The school (id) already exiss in the list", HttpStatus.BAD_REQUEST.value()));
        this.schoolData.add(schoolInfo);

    
        for (Student s: schoolInfo.getStudents())
        {
        
            if(this.schoolData.stream().anyMatch(i -> i.getId() == s.getId())) continue;
            postNewStudent(s);
        }
        for (Teacher t: schoolInfo.getTeachers())
        {
        
            if(this.schoolData.stream().anyMatch(i -> i.getId() == t.getId())) continue;
            postNewTeacher(t);
        }
        return ResponseEntity.ok().body(schoolInfo);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * * * * * STUDENT * * * * * * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Add to the list a student * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Student Management", description = "Everything to contol the students")
    @Operation(summary = "Attach the new student in the list", description="Attach the new student in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    
    @PostMapping(path = "/student")
    public ResponseEntity<Object> postNewStudent(@RequestBody Student student)
    {
        final Boolean studentExists = students.stream().anyMatch(st -> st.getId() == student.getId());
        if (studentExists) return ResponseEntity.badRequest().body(new TextResponse("The student (id) already exiss in the list", HttpStatus.BAD_REQUEST.value()));
        students.add(student);
        return ResponseEntity.ok().body(student);
    }

        /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Return the student list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Student Management", description = "Everything to contol the students")
    @Operation(summary = "Return the student list", description="Return the student list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @GetMapping(path = "/student/list")
    public ResponseEntity<Object> getAllStudents()
    {
        return ResponseEntity.ok(students);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Delete the student list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Student Management", description = "Everything to contol the students")
    @Operation(summary = "Delete the student list", description="Delete the student list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @DeleteMapping(path = "/student/list")
    public ResponseEntity<Object> deleteAllStudents()
    {
        this.students = new ArrayList<>();
        return ResponseEntity.ok(students);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Modify the student information * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Student Management", description = "Everything to contol the students")
    @Operation(summary = "Attach the default student in the list", description="Attach the default student in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @PutMapping(path = "/student/{id}")
    public ResponseEntity<Object> putEditIdStudent(@PathVariable("id") int id, @RequestBody Student student)
    {
        final int st1 = IntStream.range(0, students.size()).filter(i->students.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The Student ID (" + id + ") does not exists", HttpStatus.BAD_REQUEST.value()));
        students.remove(st1);
        students.add(student);
        return ResponseEntity.ok().body(students);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * Return the student information by ID * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Student Management", description = "Everything to contol the students")
    @Operation(summary = "Return the school data by ID", description="Return the school data by ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolHR.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @GetMapping(path = "/student/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable("id") int id)
    {
        final int st1 = IntStream.range(0, this.students.size()).filter(i->this.students.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The Student ID (" + id + ") does not exists", HttpStatus.BAD_REQUEST.value()));
        return ResponseEntity.ok().body(this.students.get(st1));
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * Delete the student information by ID * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Student Management", description = "Everything to contol the students")
    @Operation(summary = "Delete the student data by ID", description="Delete the student data by ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @DeleteMapping(path = "/student/{id}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable("id") int id)
    {
        final int st1 = IntStream.range(0, this.students.size()).filter(i->this.students.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The Student ID (" + id + ") does not exists", HttpStatus.BAD_REQUEST.value()));
        this.students.remove(st1);

        // Remove Student from SchoolData here
        for (int i = 0; i < schoolData.size(); i++)
        {
            for (int j = 0; j < schoolData.get(i).getStudents().size(); j++)
            {
                if (schoolData.get(i).getStudents().get(j).getId() == id) schoolData.get(i).getStudents().remove(j);
            }
        }

        return ResponseEntity.ok().body(new TextResponse("The student ("+ id +") has been successfully deleted", HttpStatus.ACCEPTED.value()));
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * * * * TEACHER * * * * * * * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Return the teacher list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Teacher Management", description = "Everything to contol the teachers")
    @Operation(summary = "Return the teacher list", description="Return the teacher list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @GetMapping(path = "/teacher/list")
    public ResponseEntity<Object> getAllTeachers()
    {
        return ResponseEntity.ok(teachers);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Delete the student list * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Teacher Management", description = "Everything to contol the teachers")
    @Operation(summary = "Delete the teacher list", description="Delete the teacher list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @DeleteMapping(path = "/teacher/list")
    public ResponseEntity<Object> deleteAllTeachers()
    {
        this.teachers = new ArrayList<>();
        return ResponseEntity.ok(teachers);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Modify the teacher information * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Teacher Management", description = "Everything to contol the teachers")
    @Operation(summary = "Attach the default teacher in the list", description="Attach the default teacher in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @PutMapping(path = "/teacher/{id}")
    public ResponseEntity<Object> putEditIdTeacher(@PathVariable("id") int id, @RequestBody Teacher teacher)
    {
        final int st1 = IntStream.range(0, teachers.size()).filter(i->teachers.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The Teacher ID (" + id + ") does not exists", HttpStatus.BAD_REQUEST.value()));
        teachers.remove(st1);
        teachers.add(teacher);
        return ResponseEntity.ok().body(teachers);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * * * * Add to the list a teacher * * * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Teacher Management", description = "Everything to contol the teachers")
    @Operation(summary = "Attach the new teacher in the list", description="Attach the new teacher in the list")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    
    @PostMapping(path = "/teacher")
    public ResponseEntity<Object> postNewTeacher(@RequestBody Teacher teacher)
    {
        final Boolean teacherExists = teachers.stream().anyMatch(st -> st.getId() == teacher.getId());
        if (teacherExists) return ResponseEntity.badRequest().body(new TextResponse("The teacher already exiss in the list", HttpStatus.BAD_REQUEST.value()));
        teachers.add(teacher);
        return ResponseEntity.ok().body(teacher);
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * Return the teacher information by ID * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Teacher Management", description = "Everything to contol the students")
    @Operation(summary = "Return the school data by ID", description="Return the school data by ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolHR.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @GetMapping(path = "/teacher/{id}")
    public ResponseEntity<Object> getTeacherById(@PathVariable("id") int id)
    {
        final int st1 = IntStream.range(0, this.teachers.size()).filter(i->this.teachers.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The Teacher (" + id + ") does not exist", HttpStatus.BAD_REQUEST.value()));
        return ResponseEntity.ok().body(this.teachers.get(st1));
    }

    /* * * * * * * * * * * * * * * * * * * * * * */
    /* * Delete the teacher information by ID * * */
    /* * * * * * * * * * * * * * * * * * * * * * */
    @Tag(name = "Teacher Management", description = "Everything to contol the students")
    @Operation(summary = "Delete the student data by ID", description="Delete the student data by ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode="200", description = "Successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
        @ApiResponse(responseCode="404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TextResponse.class))),
    })
    @DeleteMapping(path = "/teacher/{id}")
    public ResponseEntity<Object> deleteTeacherById(@PathVariable("id") int id)
    {
        final int st1 = IntStream.range(0, this.teachers.size()).filter(i->this.teachers.get(i).getId() == id).findFirst().orElse(-1);
        if(st1 == -1) return ResponseEntity.badRequest().body(new TextResponse("The Teacher ID (" + id + ") does not exists", HttpStatus.BAD_REQUEST.value()));
        this.teachers.remove(st1);
        
        // Remove Teacher from SchoolData here
        for (int i = 0; i < schoolData.size(); i++)
        {
            for (int j = 0; j < schoolData.get(i).getTeachers().size(); j++)
            {
                if (schoolData.get(i).getTeachers().get(j).getId() == id) schoolData.get(i).getTeachers().remove(j);
            }
        }
        return ResponseEntity.ok().body(new TextResponse("The teacher ("+ id +") has been successfully deleted", HttpStatus.ACCEPTED.value()));
    }

}
