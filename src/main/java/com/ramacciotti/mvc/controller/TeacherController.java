package com.ramacciotti.mvc.controller;

import com.ramacciotti.mvc.dto.TeacherRequestDTO;
import com.ramacciotti.mvc.model.Teacher;
import com.ramacciotti.mvc.model.Status;
import com.ramacciotti.mvc.repository.TeacherRepository;
import com.ramacciotti.mvc.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/form/show")
    public ModelAndView showForm() {
        log.info(">> showForm()");
        ModelAndView modelAndView = new ModelAndView("form.html");
        modelAndView.addObject("status", Status.values());
        return modelAndView;
    }

    @PostMapping("/form/submit")
    public String submitForm(TeacherRequestDTO teacherRequestDTO) {
        System.out.println(teacherRequestDTO.toString());
        return "redirect:/teacher/read";
    }

    @GetMapping("/read")
    public ModelAndView read() {
        log.info(">> read()");
        List<Teacher> teachers = teacherService.read();
        ModelAndView modelAndView = new ModelAndView("read_list.html");
        modelAndView.addObject("teachers", teachers);
        return modelAndView;
    }
//
//    @PostMapping("/form/submit")
//    public ModelAndView submitForm(TeacherRequestDTO teacherRequestDTO) {
//        log.info(">> submitForm()");
//        TeacherResponseDTO teacherResponseDTO = teacherService.create(teacherRequestDTO);
//        ModelAndView modelAndView = new ModelAndView("post_success.html");
//        modelAndView.addObject("name", teacherResponseDTO.getName());
//        return modelAndView;
//    }


}
