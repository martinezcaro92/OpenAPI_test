package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.School;
import io.swagger.model.Teacher;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Student
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-14T16:01:06.666Z[GMT]")


public class Student   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("school")
  @Valid
  private List<School> school = null;

  @JsonProperty("teacher")
  @Valid
  private List<Teacher> teacher = null;

  /**
   * Student califications
   */
  public enum CalificationEnum {
    OUTSTANDING("outstanding"),
    
    PASS("pass"),
    
    FAIL("fail");

    private String value;

    CalificationEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CalificationEnum fromValue(String text) {
      for (CalificationEnum b : CalificationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("calification")
  private CalificationEnum calification = null;

  public Student id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(example = "1", description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Student firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  @Schema(example = "Lagarto", required = true, description = "")
      @NotNull

    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Student lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  @Schema(example = "Sánchez", required = true, description = "")
      @NotNull

    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Student email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(example = "pepe@student.com", description = "")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Student school(List<School> school) {
    this.school = school;
    return this;
  }

  public Student addSchoolItem(School schoolItem) {
    if (this.school == null) {
      this.school = new ArrayList<School>();
    }
    this.school.add(schoolItem);
    return this;
  }

  /**
   * Get school
   * @return school
   **/
  @Schema(description = "")
      @Valid
    public List<School> getSchool() {
    return school;
  }

  public void setSchool(List<School> school) {
    this.school = school;
  }

  public Student teacher(List<Teacher> teacher) {
    this.teacher = teacher;
    return this;
  }

  public Student addTeacherItem(Teacher teacherItem) {
    if (this.teacher == null) {
      this.teacher = new ArrayList<Teacher>();
    }
    this.teacher.add(teacherItem);
    return this;
  }

  /**
   * Get teacher
   * @return teacher
   **/
  @Schema(description = "")
      @Valid
    public List<Teacher> getTeacher() {
    return teacher;
  }

  public void setTeacher(List<Teacher> teacher) {
    this.teacher = teacher;
  }

  public Student calification(CalificationEnum calification) {
    this.calification = calification;
    return this;
  }

  /**
   * Student califications
   * @return calification
   **/
  @Schema(description = "Student califications")
  
    public CalificationEnum getCalification() {
    return calification;
  }

  public void setCalification(CalificationEnum calification) {
    this.calification = calification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) &&
        Objects.equals(this.firstName, student.firstName) &&
        Objects.equals(this.lastName, student.lastName) &&
        Objects.equals(this.email, student.email) &&
        Objects.equals(this.school, student.school) &&
        Objects.equals(this.teacher, student.teacher) &&
        Objects.equals(this.calification, student.calification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, school, teacher, calification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    school: ").append(toIndentedString(school)).append("\n");
    sb.append("    teacher: ").append(toIndentedString(teacher)).append("\n");
    sb.append("    calification: ").append(toIndentedString(calification)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
