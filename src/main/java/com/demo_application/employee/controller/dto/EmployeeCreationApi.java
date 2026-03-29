package com.demo_application.employee.controller.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) para la creación de empleados a través de la API.
 * <p>
 * Esta clase encapsula los datos necesarios para crear un nuevo empleado.
 * Utiliza Lombok para la generación automática de getters, setters,
 * constructores y builder.
 * </p>
 */
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
