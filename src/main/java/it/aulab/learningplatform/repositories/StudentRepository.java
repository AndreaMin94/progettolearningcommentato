package it.aulab.learningplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.learningplatform.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
