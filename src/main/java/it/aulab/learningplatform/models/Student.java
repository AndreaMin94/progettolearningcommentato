package it.aulab.learningplatform.models;

import java.util.List;

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

@Entity
public class Student {
    @Id
    //! Se non metto la strategy non crea l'autoincrement automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
     @AttributeOverrides({
        @AttributeOverride(
            name = "firstname", //! all'attributo firstname dell'oggetto person devi mappare
            column = @Column(name="teacher_firstname", nullable = false)
        ), //! questa colonna
        @AttributeOverride(
            name = "lastname", //! all'attributo lastname dell'oggetto person devi mappare
            column = @Column(name="teacher_lastname", nullable = false)
        ) //! questa colonna
    })
    private Person data;

    @Column(nullable=false)
    private String email;

    @ManyToMany(mappedBy = "courses")
    private List<Course> courses;


    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
