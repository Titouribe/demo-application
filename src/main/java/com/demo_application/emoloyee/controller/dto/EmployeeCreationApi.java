package com.demo_application.emoloyee.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreationApi implements Serializable {

    @Serial
    private static final long serialVersionUID = -175951324627594099L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private double salaryPerHour;
}
