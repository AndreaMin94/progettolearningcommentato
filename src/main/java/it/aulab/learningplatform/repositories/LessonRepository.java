package it.aulab.learningplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.learningplatform.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    
}
