package it.aulab.learningplatform.util.mapping;

import org.modelmapper.PropertyMap;

import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.models.Course;

public class CreateCourseDTOToCoursePropertyMap extends PropertyMap<CreateCourseDTO, Course>{
    @Override
    protected void configure(){
        using(new ConvertStringToDate()).map(source.getDate()).setDate(null);
    }
}
