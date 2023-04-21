package it.aulab.learningplatform.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.learningplatform.models.Course;
import it.aulab.learningplatform.models.Person;

public interface CourseRepository extends JpaRepository<Course, Long>{
    List<Course> findByNameContaining(String name);
    List<Course> findByTeacherFirstNameContaining(String name);
    List<Course> findByNameContainingAndTeacherFirstNameContaining(String name, String teacherFirstName);
    List<Course> findByTeacherLastNameContaining(String name);
    List<Course> findByNameContainingAndTeacherLastNameContaining(String name, String teacherLastName);
    List<Course> findByTeacherFirstNameContainingAndTeacherLastNameContaining(String teacherFirstName, String teacherLastName);
    List<Course> findByNameContainingAndTeacherFirstNameContainingAndTeacherLastNameContaining(String name,String teacherFirstName, String teacherLastName);


}
