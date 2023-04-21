package it.aulab.learningplatform.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.dto.UpdateCourseDTO;
import it.aulab.learningplatform.models.Course;
import it.aulab.learningplatform.repositories.CourseRepository;
import it.aulab.learningplatform.util.exception.CourseNotFound;
@Service("courseService")
public class CourseService implements CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CourseDTO> readAll() {
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();
        for(Course c : courseRepository.findAll()){
            dtos.add(mapper.map(c, CourseDTO.class));
        }
        return dtos;
    }

    @Override
    public CourseDTO readOne(Long id) throws Exception {
        return mapper.map(this.exists(id), CourseDTO.class);
    }

    @Override
    public List<CourseDTO> read(Map<String, String> params) {
        String nameFilter = params.get("name");
        String teacherFirstName = params.get("teacherFirstname");
        String teacherLastName = params.get("teacherLastname");

        List<Course> courses;

        if(nameFilter != null && teacherFirstName != null && teacherLastName != null){
            courses = courseRepository.findByNameContainingAndTeacherFirstNameContainingAndTeacherLastNameContaining(nameFilter, teacherFirstName, teacherLastName);
        } else if( teacherFirstName != null && teacherLastName != null){
            courses = courseRepository.findByTeacherFirstNameContainingAndTeacherLastNameContaining(teacherFirstName, teacherLastName);
        } else if (teacherFirstName != null && nameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherFirstNameContaining(nameFilter, teacherFirstName);
        } else if (teacherLastName != null && nameFilter != null){
            courses = courseRepository.findByNameContainingAndTeacherLastNameContaining(nameFilter, teacherLastName);
        } else if (nameFilter != null){
            courses = courseRepository.findByNameContaining(nameFilter);
        }  else if (teacherFirstName != null) {
            courses = courseRepository.findByTeacherFirstNameContaining(teacherFirstName);
        } else if (teacherLastName != null){
            courses = courseRepository.findByTeacherLastNameContaining(teacherLastName);
        } else {
            courses = courseRepository.findAll();
        }

        return courses.stream().map((c) -> mapper.map(c, CourseDTO.class)).toList();
    }

    @Override
    public CourseDTO create(CreateCourseDTO createDTO) {
        Course course = mapper.map(createDTO, Course.class);
        return mapper.map(courseRepository.save(course), CourseDTO.class);
    }

    @Override
    public CourseDTO update(Long id, UpdateCourseDTO updateDto) throws Exception{
        Course dbCourse = this.exists(id);
        dbCourse.setDescription(updateDto.getDescription());
        dbCourse.setDate(LocalDate.parse(updateDto.getDate()));
        courseRepository.save(dbCourse);
        return mapper.map(dbCourse, CourseDTO.class);
    }

    @Override
    public CourseDTO delete(Long id) throws Exception {
        Course course = this.exists(id);
        CourseDTO courseDto = mapper.map(course, CourseDTO.class);
        courseRepository.deleteById(id);
        return courseDto;
    }

    private Course exists(Long id) throws Exception {
        if(courseRepository.existsById(id)) return courseRepository.findById(id).get();
        throw new CourseNotFound();
    }

    
}
