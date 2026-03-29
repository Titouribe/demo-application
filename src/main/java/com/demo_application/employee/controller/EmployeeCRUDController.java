package com.demo_application.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo_application.employee.controller.dto.EmployeeCreationApi;
import com.demo_application.employee.controller.dto.EmployeeViewApi;
import com.demo_application.employee.controller.mapper.EmployeeDTOMapper;
import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.domain.service.EmployeeService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador REST para operaciones CRUD masivas de empleados.
 * <p>
 * Permite consultar, crear y eliminar empleados en lote mediante la API.
 * </p>
 */
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeCRUDController {

    private final EmployeeService employeeService;
    private final EmployeeDTOMapper employeeDtoMapper;

    /**
     * Obtiene la lista de todos los empleados.
     * 
     * @return Lista de empleados en formato de vista (API)
     */
    @GetMapping
    public List<EmployeeViewApi> viewAll() {
        return employeeService.findAll().stream()
                .map(employeeDtoMapper::toDto)
                .toList();
    }

    /**
     * Crea empleados en lote a partir de una lista de DTOs de creación.
     * 
     * @param employeeDtos Lista de empleados a crear
     * @return Lista de empleados creados en formato de vista (API)
     */
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

    /**
     * Elimina empleados en lote a partir de una lista de IDs.
     * 
     * @param ids Lista de IDs de empleados a eliminar
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBulk(@RequestBody List<Long> ids) {
        employeeService.deleteAllByIds(ids);
    }
}
