package com.demo_application.employee.controller;

import com.demo_application.employee.controller.dto.EmployeeCreationApi;
import com.demo_application.employee.controller.dto.EmployeeViewApi;
import com.demo_application.employee.controller.mapper.EmployeeDTOMapper;
import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.domain.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeCRUDController {

    private final EmployeeService employeeService;
    private final EmployeeDTOMapper employeeDtoMapper;

    @GetMapping
    public List<EmployeeViewApi> viewAll() {
        return employeeService.findAll().stream()
                .map(employeeDtoMapper::toDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<EmployeeViewApi> create(@RequestBody List<EmployeeCreationApi> employeeDtos) {

        List<Employee> employees = employeeDtos.stream()
                .map(employeeDtoMapper::toDomain)
                .toList();

        List<Employee> savedEmployees = employeeService.saveAll(employees);
        return savedEmployees.stream()
                .map(employeeDtoMapper::toDto)
                .toList();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBulk(@RequestBody List<Long> ids) {
        employeeService.deleteAllByIds(ids);
    }
}
