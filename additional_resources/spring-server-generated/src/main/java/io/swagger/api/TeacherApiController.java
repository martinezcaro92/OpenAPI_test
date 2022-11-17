package io.swagger.api;

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
public class TeacherApiController implements TeacherApi {

    private static final Logger log = LoggerFactory.getLogger(TeacherApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TeacherApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Teacher> addTeacher(@Parameter(in = ParameterIn.DEFAULT, description = "Create a new teacher in the school", required=true, schema=@Schema()) @Valid @RequestBody Teacher body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Teacher>(objectMapper.readValue("{\n  \"firstName\" : \"John\",\n  \"lastName\" : \"James\",\n  \"phone\" : \"12345\",\n  \"id\" : 10,\n  \"email\" : \"john@email.com\"\n}", Teacher.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Teacher>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Teacher>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTeacher(@Parameter(in = ParameterIn.PATH, description = "Teacher id to delete", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTeachers() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Teacher> getTeacherById(@Parameter(in = ParameterIn.PATH, description = "ID of Teacher to return", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Teacher>(objectMapper.readValue("{\n  \"firstName\" : \"John\",\n  \"lastName\" : \"James\",\n  \"phone\" : \"12345\",\n  \"id\" : 10,\n  \"email\" : \"john@email.com\"\n}", Teacher.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Teacher>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Teacher>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Teacher> returnAllTeachers() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Teacher>(objectMapper.readValue("{\n  \"firstName\" : \"John\",\n  \"lastName\" : \"James\",\n  \"phone\" : \"12345\",\n  \"id\" : 10,\n  \"email\" : \"john@email.com\"\n}", Teacher.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Teacher>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Teacher>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Teacher> updateTeacherWithForm(@Parameter(in = ParameterIn.PATH, description = "ID of Teacher that needs to be updated", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Teacher>(objectMapper.readValue("{\n  \"firstName\" : \"John\",\n  \"lastName\" : \"James\",\n  \"phone\" : \"12345\",\n  \"id\" : 10,\n  \"email\" : \"john@email.com\"\n}", Teacher.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Teacher>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Teacher>(HttpStatus.NOT_IMPLEMENTED);
    }

}
