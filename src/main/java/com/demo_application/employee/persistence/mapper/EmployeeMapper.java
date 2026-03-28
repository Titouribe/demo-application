package com.demo_application.employee.persistence.mapper;

import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.persistence.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toDomain(EmployeeEntity entity) {
        if (entity == null) {
            return null;
        }

        return Employee.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName()) // Maps perfectly even though the DB column is 'second_name'
                .email(entity.getEmail())
                .salaryPerHour(entity.getSalaryPerHour())
                .createdDate(entity.getCreatedDate())
                .build();
    }

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
