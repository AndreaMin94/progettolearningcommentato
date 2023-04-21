package it.aulab.learningplatform;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.aulab.learningplatform.util.mapping.CourseToCourseDTOPropertyMap;
import it.aulab.learningplatform.util.mapping.CreateCourseDTOToCoursePropertyMap;

@SpringBootApplication
public class LearningplatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningplatformApplication.class, args);
	}

	@Bean
	public ModelMapper instanceModelMapper(){
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new CreateCourseDTOToCoursePropertyMap());
		mapper.addMappings(new CourseToCourseDTOPropertyMap());
		return mapper;
	}

}
