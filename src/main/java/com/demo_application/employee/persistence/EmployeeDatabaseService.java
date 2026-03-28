package com.demo_application.employee.persistence;

import com.demo_application.employee.domain.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeDatabaseService {

    List<Employee> findAll();

    List<Employee> saveAll(Collection<Employee> employees);

    void deleteAllByIds(Collection<Long> ids);
}
