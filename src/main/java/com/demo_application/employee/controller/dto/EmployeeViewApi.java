package com.demo_application.employee.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeViewApi implements Serializable {

    @Serial
    private static final long serialVersionUID = -1290197793303499706L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private double salaryPerHour;

    private ZonedDateTime createdDate;
}
