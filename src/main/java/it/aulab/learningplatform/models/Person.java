package it.aulab.learningplatform.models;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable //! puo' essere utilizzato come Teacher e come Student. Puo' essre inserito all'interno di un'altra entita'
public class Person {
    @Column(nullable=false)
    private String firstname;
    @Column(nullable=false)
    private String lastname;
    public Person() {
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
