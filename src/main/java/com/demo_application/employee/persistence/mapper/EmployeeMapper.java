package com.demo_application.employee.persistence.mapper;

import org.springframework.stereotype.Component;

import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.persistence.entity.EmployeeEntity;

/**
 * Mapper para convertir entre entidades JPA y objetos de dominio Employee.
 * <p>
 * Facilita el desacoplamiento entre la capa de persistencia y la de dominio.
 * </p>
 */
@Component
public class EmployeeMapper {

    /**
     * Convierte una entidad JPA en un objeto de dominio Employee.
     * 
     * @param entity Entidad EmployeeEntity
     * @return Objeto Employee de dominio o null si entity es null
     */
    public Employee toDomain(EmployeeEntity entity) {
        if (entity == null) {
            return null;
        }

        return Employee.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .salaryPerHour(entity.getSalaryPerHour())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    /**
     * Convierte un objeto de dominio Employee en una entidad JPA.
     * 
     * @param domain Objeto Employee de dominio
     * @return Entidad EmployeeEntity o null si domain es null
     */
    public EmployeeEntity toEntity(Employee domain) {
        if (domain == null) {
            return null;
        }

        return EmployeeEntity.builder()
                .id(domain.getId())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .email(domain.getEmail())
                .salaryPerHour(domain.getSalaryPerHour())
                .createdDate(domain.getCreatedDate())
                .build();
    }
}
