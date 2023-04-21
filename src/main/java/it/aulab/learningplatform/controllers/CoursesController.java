package it.aulab.learningplatform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.dto.UpdateCourseDTO;
import it.aulab.learningplatform.services.CrudService;

@Controller
@RequestMapping(value="courses")
public class CoursesController {
    @Autowired
    private CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> service;

    @GetMapping
    public String showListView(Model model){
        model.addAttribute("title", "Corsi");
        model.addAttribute("courses", service.readAll());
        return "courses";
    }
}
