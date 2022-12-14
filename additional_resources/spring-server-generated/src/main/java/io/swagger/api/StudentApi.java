/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.36).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.School;
import io.swagger.model.Student;
import io.swagger.model.Teacher;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-14T16:01:06.666Z[GMT]")
@Validated
public interface StudentApi {

    @Operation(summary = "Add a new student to the list", description = "Add a new student to the list", security = {
        @SecurityRequirement(name = "schoolResources_auth", scopes = {
            "write:students",
"read:students",
"write:teachers",
"read:teachers",
"write:schools",
"read:schools"        })    }, tags={ "student" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/student",
        consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> addStudent(@Parameter(in = ParameterIn.DEFAULT, description = "Create a new student in the school", required=true, schema=@Schema()) @Valid @RequestBody Student body);


    @Operation(summary = "Deletes a student", description = "delete a student", security = {
        @SecurityRequirement(name = "schoolResources_auth", scopes = {
            "write:students",
"read:students",
"write:teachers",
"read:teachers",
"write:schools",
"read:schools"        })    }, tags={ "student" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation"),
        
        @ApiResponse(responseCode = "400", description = "Invalid pet value") })
    @RequestMapping(value = "/student/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteStudent(@Parameter(in = ParameterIn.PATH, description = "Student id to delete", required=true, schema=@Schema()) @PathVariable("id") Long id);


    @Operation(summary = "Deletes all students", description = "delete all students", security = {
        @SecurityRequirement(name = "schoolResources_auth", scopes = {
            "write:students",
"read:students",
"write:teachers",
"read:teachers",
"write:schools",
"read:schools"        })    }, tags={ "student" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation"),
        
        @ApiResponse(responseCode = "400", description = "Invalid pet value") })
    @RequestMapping(value = "/student",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteStudents();


    @Operation(summary = "Find student by ID", description = "Returns a single student", security = {
        @SecurityRequirement(name = "api_key"),
@SecurityRequirement(name = "schoolResources_auth", scopes = {
            "write:students",
"read:students",
"write:teachers",
"read:teachers",
"write:schools",
"read:schools"        })    }, tags={ "student" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "404", description = "Student not found") })
    @RequestMapping(value = "/student/{id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<Student> getStudentById(@Parameter(in = ParameterIn.PATH, description = "ID of pet to return", required=true, schema=@Schema()) @PathVariable("id") Long id);


    @Operation(summary = "Returns the list with all students", description = "Returns the list with all students", security = {
        @SecurityRequirement(name = "schoolResources_auth", scopes = {
            "write:students",
"read:students",
"write:teachers",
"read:teachers",
"write:schools",
"read:schools"        })    }, tags={ "student" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
        
        @ApiResponse(responseCode = "404", description = "Students not found") })
    @RequestMapping(value = "/student",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<Student> returnAllStudents();


    @Operation(summary = "Updates a pet in the store with form data", description = "", security = {
        @SecurityRequirement(name = "schoolResources_auth", scopes = {
            "write:students",
"read:students",
"write:teachers",
"read:teachers",
"write:schools",
"read:schools"        })    }, tags={ "student" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation"),
        
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/student/{id}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateStudentWithForm(@Parameter(in = ParameterIn.PATH, description = "ID of student that needs to be updated", required=true, schema=@Schema()) @PathVariable("id") Long id);

}

