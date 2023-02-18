package com.ramacciotti.mvc.utils;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleRequestWithNullOrBlankFields(BindingResult bindingResult) {

        var exceptionList = bindingResult.getFieldErrors();

        ModelAndView modelAndView = new ModelAndView("error.html");
        modelAndView.addObject("exceptionList", exceptionList);

        return modelAndView;

    }

}
