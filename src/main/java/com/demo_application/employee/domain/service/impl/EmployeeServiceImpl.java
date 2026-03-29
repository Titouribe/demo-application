package com.demo_application.employee.domain.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.domain.service.EmployeeService;
import com.demo_application.employee.persistence.EmployeeDatabaseService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * Implementación del servicio de dominio para la gestión de empleados.
 * <p>
 * Realiza operaciones de negocio y delega el acceso a datos en
 * EmployeeDatabaseService.
 * Incluye validaciones de unicidad de email y manejo transaccional.
 * </p>
 */
@RequiredArgsConstructor
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDatabaseService employeeDatabaseService;

    /**
     * Guarda una colección de empleados, validando unicidad de email.
     * 
     * @param employees Empleados a guardar
     * @return Lista de empleados guardados
     * @throws IllegalArgumentException si algún email ya existe
     */
    @Override
    public List<Employee> saveAll(Collection<Employee> employees) {
        for (Employee employee : employees) {
            String email = employee.getEmail();
            if (email != null && !email.isBlank()) {
                boolean emailTaken = employeeDatabaseService.findAll().stream()
                        .filter(e -> employee.getId() == null || !e.getId().equals(employee.getId()))
                        .anyMatch(e -> email.equalsIgnoreCase(e.getEmail()));
                if (emailTaken) {
                    throw new IllegalArgumentException(
                            "Ya existe un empleado registrado con el email: " + email);
                }
            }
        }
        return employeeDatabaseService.saveAll(employees);
    }

    /**
     * Obtiene todos los empleados registrados.
     * 
     * @return Lista de empleados
     */
    @Override
    public List<Employee> findAll() {
        return employeeDatabaseService.findAll();
    }

    /**
     * Elimina empleados por sus IDs.
     * 
     * @param ids Colección de IDs a eliminar
     */
    @Override
    public void deleteAllByIds(Collection<Long> ids) {
        employeeDatabaseService.deleteAllByIds(ids);
    }
}
