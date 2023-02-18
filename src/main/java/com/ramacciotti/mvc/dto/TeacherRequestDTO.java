package com.ramacciotti.mvc.dto;

import com.ramacciotti.mvc.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequestDTO {

    private String name;

    private BigDecimal salary;

    private Status status;

}
