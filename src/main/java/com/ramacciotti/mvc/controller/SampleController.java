package com.ramacciotti.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SampleController {

    // Type 1
    @GetMapping("/servlet")
    public String hello(HttpServletRequest servletRequest) {
        log.info(">> Servlet");
        servletRequest.setAttribute("name", "Mariana");
        return "sample.html"; // Spring will render the sample.html page inside the 'resources/templates' folder.
    }

    // Type 2
    @GetMapping("/model")
    public String hello(Model model) {
        log.info(">> Model");
        model.addAttribute("name", "Mariana");
        return "sample.html"; // Spring will render the sample.html page inside the 'resources/templates' folder.
    }

    // Type 3
    @GetMapping("/model-and-view")
    public ModelAndView hello() {
        log.info(">> ModelAndView");
        ModelAndView modelAndView = new ModelAndView("sample.html"); // ModelAndView: this interface allows us to pass all the information required by Spring MVC in one return
        modelAndView.addObject("name", "Mariana"); // add an object in this model
        return modelAndView;
    }

}
