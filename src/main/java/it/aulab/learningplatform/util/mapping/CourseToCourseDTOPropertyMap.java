package it.aulab.learningplatform.util.mapping;

import org.modelmapper.PropertyMap;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.models.Course;

public class CourseToCourseDTOPropertyMap extends PropertyMap<Course, CourseDTO>{
    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getStudents()).setNumbersOfStudents(null);
    }
}
