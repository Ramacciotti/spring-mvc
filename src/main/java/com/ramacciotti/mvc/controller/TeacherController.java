package com.ramacciotti.mvc.controller;

import com.ramacciotti.mvc.model.Teacher;
import com.ramacciotti.mvc.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public ModelAndView getAll() {
        List<Teacher> teachers = teacherService.getAll();
        ModelAndView modelAndView = new ModelAndView("teachers/index.html");
        modelAndView.addObject("teachers", teachers);
        return modelAndView;
    }

}
