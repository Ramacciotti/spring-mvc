package com.ramacciotti.mvc.service;

import com.ramacciotti.mvc.dto.TeacherRequestDTO;
import com.ramacciotti.mvc.dto.TeacherResponseDTO;
import com.ramacciotti.mvc.model.Teacher;
import com.ramacciotti.mvc.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherResponseDTO create(TeacherRequestDTO teacherRequestDTO) {

        Teacher teacher = new Teacher()
                .withName(teacherRequestDTO.getName())
                .withStatus(teacherRequestDTO.getStatus())
                .withSalary(teacherRequestDTO.getSalary());

        teacher = teacherRepository.save(teacher);

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(teacher, TeacherResponseDTO.class);

    }

    public List<Teacher> read() {

        return teacherRepository.findAll();

    }


}
