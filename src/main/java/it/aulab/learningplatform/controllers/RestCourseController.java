package it.aulab.learningplatform.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.dto.UpdateCourseDTO;
import it.aulab.learningplatform.services.CrudService;

@RestController
@RequestMapping("api/courses")
public class RestCourseController {
   
    //! METODO SBAGLIATO
    // @Autowired
    // private CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> service;
    //! METODO CORRETTO
    @Autowired
    @Qualifier("courseService")
    private CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> service;


    @GetMapping
    public List<CourseDTO> get(@RequestParam Map<String, String> params){
        return service.readAll();
    }

    @GetMapping("{id}")
    public CourseDTO getOne(@PathVariable Long id) throws Exception{
        return service.readOne(id);
    }

    @PostMapping
    public CourseDTO insert(@RequestBody CreateCourseDTO dto) throws Exception{
        return service.create(dto);
    }

    @PutMapping("{id}")
    public CourseDTO update(@PathVariable("id") Long id , @RequestBody UpdateCourseDTO dto) throws Exception{
        return service.update(id, dto);
    }

    // @PatchMapping("{id}")
    // public CourseDTO updateByFields(){

    // }

    @DeleteMapping("{id}")
    public CourseDTO delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }
}
