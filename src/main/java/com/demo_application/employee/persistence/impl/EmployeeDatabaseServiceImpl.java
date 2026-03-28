package com.demo_application.employee.persistence.impl;

import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.persistence.EmployeeDatabaseService;
import com.demo_application.employee.persistence.mapper.EmployeeMapper;
import com.demo_application.employee.persistence.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeDatabaseServiceImpl implements EmployeeDatabaseService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDomain)
                .toList();
    }

    @Override
    public List<Employee> saveAll(Collection<Employee> employees) {

        return employees.stream()
                .map(employeeMapper::toEntity)
                .map(employeeRepository::save)
                .map(employeeMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteAllByIds(Collection<Long> ids) {
        employeeRepository.deleteAllById(ids);
    }
}
