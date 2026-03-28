package com.demo_application.emoloyee.domain.service;

import com.demo_application.emoloyee.domain.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    List<Employee> saveAll(Collection<Employee> employees);

    List<Employee> findAll();

    void deleteAllByIds(Collection<Long> ids);
}
