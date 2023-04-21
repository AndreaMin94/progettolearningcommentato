package it.aulab.learningplatform.dto;

import java.util.List;

import it.aulab.learningplatform.models.Lesson;
import it.aulab.learningplatform.models.Student;

public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private String teacherFirstname;
    private String teacherLastname;
    private String date;
    private Integer numbersOfStudents;
    private List<Lesson> lessons;
    private List<Student> students;
    public CourseDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTeacherFirstname() {
        return teacherFirstname;
    }
    public void setTeacherFirstname(String teacherFirstname) {
        this.teacherFirstname = teacherFirstname;
    }
    public String getTeacherLastname() {
        return teacherLastname;
    }
    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getNumbersOfStudents() {
        return numbersOfStudents;
    }
    public void setNumbersOfStudents(Integer numbersOfStudents) {
        this.numbersOfStudents = numbersOfStudents;
    }
}
