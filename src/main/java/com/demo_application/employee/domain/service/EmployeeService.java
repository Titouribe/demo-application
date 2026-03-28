package com.demo_application.employee.domain.service;

import com.demo_application.employee.domain.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    List<Employee> saveAll(Collection<Employee> employees);

    List<Employee> findAll();

    void deleteAllByIds(Collection<Long> ids);
}
