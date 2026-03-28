package com.demo_application.emoloyee.controller.mapper;

import com.demo_application.emoloyee.controller.dto.EmployeeCreationApi;
import com.demo_application.emoloyee.controller.dto.EmployeeViewApi;
import com.demo_application.emoloyee.domain.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDTOMapper {

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
}