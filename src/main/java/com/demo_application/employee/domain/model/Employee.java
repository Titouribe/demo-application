package com.demo_application.employee.domain.model;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad de dominio que representa un empleado en el sistema.
 * <p>
 * Incluye información básica como nombre, email, salario y fecha de creación.
 * Utiliza Lombok para la generación automática de métodos y constructores.
 * </p>
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private double salaryPerHour;
    private ZonedDateTime createdDate;
}