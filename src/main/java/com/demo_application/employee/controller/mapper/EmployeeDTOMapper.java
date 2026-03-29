package com.demo_application.employee.controller.mapper;

import org.springframework.stereotype.Component;

import com.demo_application.employee.controller.dto.EmployeeCreationApi;
import com.demo_application.employee.controller.dto.EmployeeViewApi;
import com.demo_application.employee.domain.model.Employee;

/**
 * Mapper para convertir entre entidades de dominio Employee y sus DTOs de API.
 * <p>
 * Permite transformar objetos entre las capas de dominio y presentación (API),
 * facilitando la separación de responsabilidades y el desacoplamiento.
 * </p>
 */
@Component
public class EmployeeDTOMapper {

    /**
     * Convierte un DTO de creación de empleado en una entidad de dominio Employee.
     * 
     * @param dto DTO con los datos de creación
     * @return Instancia de Employee o null si dto es null
     */
    public Employee toDomain(EmployeeCreationApi dto) {
        if (dto == null) {
            return null;
        }

        return Employee.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .salaryPerHour(dto.getSalaryPerHour())
                .build();
    }

    /**
     * Convierte una entidad de dominio Employee en un DTO para vista (API).
     * 
     * @param domain Entidad Employee
     * @return DTO para exponer datos de empleado o null si domain es null
     */
    public EmployeeViewApi toDto(Employee domain) {
        if (domain == null) {
            return null;
        }

        return EmployeeViewApi.builder()
                .id(domain.getId())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .email(domain.getEmail())
                .salaryPerHour(domain.getSalaryPerHour())
                .createdDate(domain.getCreatedDate())
                .build();
    }

    /**
     * Convierte una entidad de dominio Employee en un DTO de creación (útil para
     * edición).
     * 
     * @param domain Entidad Employee
     * @return DTO de creación o null si domain es null
     */
    public EmployeeCreationApi toCreationDto(Employee domain) {
        if (domain == null)
            return null;
        return EmployeeCreationApi.builder()
                .id(domain.getId())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .email(domain.getEmail())
                .salaryPerHour(domain.getSalaryPerHour())
                .build();
    }
}