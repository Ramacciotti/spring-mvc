package com.ramacciotti.mvc.service;

import com.ramacciotti.mvc.model.Teacher;
import com.ramacciotti.mvc.model.TeacherStatus;
import com.ramacciotti.mvc.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAll() {

        buildTeachersList();

        return teacherRepository.findAll();

    }

    private void buildTeachersList() {

        Teacher teacher1 = new Teacher("Marcelo", BigDecimal.valueOf(5000), TeacherStatus.ACTIVE );
        Teacher teacher2 = new Teacher("Marcia",BigDecimal.valueOf(2000), TeacherStatus.ACTIVE );
        Teacher teacher3 = new Teacher("Merida",BigDecimal.valueOf(1500), TeacherStatus.INACTIVE );

        List<Teacher> teachers = Arrays.asList(teacher1, teacher2, teacher3);

        teacherRepository.saveAll(teachers);

    }

}
