package com.demo_application.employee.controller.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para exponer los datos de un empleado a través de la API.
 * <p>
 * Utiliza Lombok para la generación automática de getters, setters,
 * constructores y builder.
 * </p>
 */
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
