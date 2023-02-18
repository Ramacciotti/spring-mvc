package com.ramacciotti.mvc.dto;

import com.ramacciotti.mvc.model.Status;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class TeacherRequestDTO {

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @NotNull
    private BigDecimal salary;

    private Status status;

}
