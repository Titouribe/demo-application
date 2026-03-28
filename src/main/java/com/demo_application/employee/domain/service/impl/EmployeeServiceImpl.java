package com.demo_application.employee.domain.service.impl;

import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.domain.service.EmployeeService;
import com.demo_application.employee.persistence.EmployeeDatabaseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDatabaseService employeeDatabaseService;

    @Override
    public List<Employee> saveAll(Collection<Employee> employees) {
        return employeeDatabaseService.saveAll(employees);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDatabaseService.findAll();
    }

    @Override
    public void deleteAllByIds(Collection<Long> ids) {
        employeeDatabaseService.deleteAllByIds(ids);
    }
}
