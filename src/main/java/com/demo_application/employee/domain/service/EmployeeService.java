package com.demo_application.employee.domain.service;

import java.util.Collection;
import java.util.List;

import com.demo_application.employee.domain.model.Employee;

/**
 * Servicio de dominio para la gestión de empleados.
 * <p>
 * Define las operaciones principales de negocio sobre empleados.
 * </p>
 */
public interface EmployeeService {

    /**
     * Guarda una colección de empleados.
     * 
     * @param employees Empleados a guardar
     * @return Lista de empleados guardados
     */
    List<Employee> saveAll(Collection<Employee> employees);

    /**
     * Obtiene todos los empleados registrados.
     * 
     * @return Lista de empleados
     */
    List<Employee> findAll();

    /**
     * Elimina empleados por sus IDs.
     * 
     * @param ids Colección de IDs a eliminar
     */
    void deleteAllByIds(Collection<Long> ids);
}
