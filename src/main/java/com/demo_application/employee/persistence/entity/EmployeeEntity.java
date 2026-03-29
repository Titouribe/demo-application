package com.demo_application.employee.persistence.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entidad JPA que representa la tabla 'employee' en la base de datos.
 * <p>
 * Incluye información personal, salario y fecha de creación del empleado.
 * Utiliza anotaciones de Lombok y JPA para facilitar el mapeo y la generación
 * de código.
 * </p>
 */
@Entity
@Table(name = "employee")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private ZonedDateTime createdDate;
}
