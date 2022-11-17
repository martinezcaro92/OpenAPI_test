package io.swagger.api;

import io.swagger.model.School;
import io.swagger.model.Student;
import io.swagger.model.Teacher;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-14T16:01:06.666Z[GMT]")
@RestController
public class StudentApiController implements StudentApi {

    private static final Logger log = LoggerFactory.getLogger(StudentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StudentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addStudent(@Parameter(in = ParameterIn.DEFAULT, description = "Create a new student in the school", required=true, schema=@Schema()) @Valid @RequestBody Student body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteStudent(@Parameter(in = ParameterIn.PATH, description = "Student id to delete", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteStudents() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Student> getStudentById(@Parameter(in = ParameterIn.PATH, description = "ID of pet to return", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Student>(objectMapper.readValue("{\n  \"firstName\" : \"Lagarto\",\n  \"lastName\" : \"Sánchez\",\n  \"teacher\" : [ {\n    \"firstName\" : \"John\",\n    \"lastName\" : \"James\",\n    \"phone\" : \"12345\",\n    \"id\" : 10,\n    \"email\" : \"john@email.com\"\n  }, {\n    \"firstName\" : \"John\",\n    \"lastName\" : \"James\",\n    \"phone\" : \"12345\",\n    \"id\" : 10,\n    \"email\" : \"john@email.com\"\n  } ],\n  \"school\" : [ {\n    \"name\" : \"IES Juan de la Cierva\",\n    \"id\" : 1,\n    \"class\" : \"1CC\"\n  }, {\n    \"name\" : \"IES Juan de la Cierva\",\n    \"id\" : 1,\n    \"class\" : \"1CC\"\n  } ],\n  \"id\" : 1,\n  \"calification\" : \"outstanding\",\n  \"email\" : \"pepe@student.com\"\n}", Student.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Student>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Student> returnAllStudents() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Student>(objectMapper.readValue("{\n  \"firstName\" : \"Lagarto\",\n  \"lastName\" : \"Sánchez\",\n  \"teacher\" : [ {\n    \"firstName\" : \"John\",\n    \"lastName\" : \"James\",\n    \"phone\" : \"12345\",\n    \"id\" : 10,\n    \"email\" : \"john@email.com\"\n  }, {\n    \"firstName\" : \"John\",\n    \"lastName\" : \"James\",\n    \"phone\" : \"12345\",\n    \"id\" : 10,\n    \"email\" : \"john@email.com\"\n  } ],\n  \"school\" : [ {\n    \"name\" : \"IES Juan de la Cierva\",\n    \"id\" : 1,\n    \"class\" : \"1CC\"\n  }, {\n    \"name\" : \"IES Juan de la Cierva\",\n    \"id\" : 1,\n    \"class\" : \"1CC\"\n  } ],\n  \"id\" : 1,\n  \"calification\" : \"outstanding\",\n  \"email\" : \"pepe@student.com\"\n}", Student.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Student>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateStudentWithForm(@Parameter(in = ParameterIn.PATH, description = "ID of student that needs to be updated", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
