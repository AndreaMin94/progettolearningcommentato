package it.aulab.learningplatform.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//! java persistence api
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    
    //! per mappare firstname e lastname del teacher creiamo una classe Person
    @Embedded //! in automatico mapper' il teacher in un oggetto di classe person
    //! ora definiamo i campi ( firstname e lastname )
    @AttributeOverrides({
        @AttributeOverride(
            name = "firstname", //! all'attributo firstname dell'oggetto person devi mappare
            column = @Column(
                name="teacher_firstname",
                nullable = false,
                length = 100)
        ), //! questa colonna
        @AttributeOverride(
            name = "lastname", //! all'attributo lastname dell'oggetto person devi mappare
            column = @Column(
                name="teacher_lastname", 
                nullable = false,
                length = 100)
        ) //! questa colonna
    })
    private Person teacher;

    //! @Column(columnDefinition = "DATE") commentato per farlo fare a hibernate
    private LocalDate date;

    @OneToMany(mappedBy = "course") //! VA SEMPRE SPECIFICATA ( ci indica il titolare della relazione )
    private List<Lesson> lessons = new ArrayList<Lesson>();

    @ManyToMany
    @JoinTable(
        name = "course_student",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name ="student_id")
    )
    private List<Student> students;

    public Course() {
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

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
