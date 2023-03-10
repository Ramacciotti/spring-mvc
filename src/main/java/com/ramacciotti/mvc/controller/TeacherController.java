package com.ramacciotti.mvc.controller;

import com.ramacciotti.mvc.dto.TeacherRequestDTO;
import com.ramacciotti.mvc.model.Status;
import com.ramacciotti.mvc.model.Teacher;
import com.ramacciotti.mvc.service.TeacherService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/list")
    public ModelAndView read() {
        log.info(">> list()");
        List<Teacher> teachers = teacherService.read();
        ModelAndView modelAndView = new ModelAndView("list.html");
        modelAndView.addObject("teachers", teachers);
        return modelAndView;
    }

    @GetMapping("/form/show")
    public ModelAndView showForm() {
        log.info(">> showForm()");
        ModelAndView modelAndView = new ModelAndView("form.html");
        modelAndView.addObject("teacherRequestDTO", new TeacherRequestDTO()); // bindindg Object to form
        modelAndView.addObject("statusValues", Status.values());
        return modelAndView;
    }

    @PostMapping("/form/submit")
    public ModelAndView submitForm(@Valid TeacherRequestDTO teacherRequestDTO) {
        log.info(">> submitForm()");
        teacherService.create(teacherRequestDTO);
        return new ModelAndView("redirect:/teacher/list");
    }


}
