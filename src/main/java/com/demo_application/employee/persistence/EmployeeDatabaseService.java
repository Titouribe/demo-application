package com.demo_application.employee.persistence;

import java.util.Collection;
import java.util.List;

import com.demo_application.employee.domain.model.Employee;

/**
 * Servicio de acceso a datos para empleados.
 * <p>
 * Define operaciones CRUD y consultas específicas sobre empleados en la base de
 * datos.
 * </p>
 */
public interface EmployeeDatabaseService {

    /**
     * Obtiene todos los empleados desde la base de datos.
     * 
     * @return Lista de empleados de dominio
     */
    List<Employee> findAll();

    /**
     * Guarda una colección de empleados en la base de datos.
     * 
     * @param employees Empleados de dominio a guardar
     * @return Lista de empleados guardados (dominio)
     */
    List<Employee> saveAll(Collection<Employee> employees);

    /**
     * Elimina empleados por sus IDs.
     * 
     * @param ids Colección de IDs a eliminar
     */
    void deleteAllByIds(Collection<Long> ids);

    /**
     * Verifica si existe un empleado con el email dado.
     * 
     * @param email Email a buscar
     * @return true si existe, false en caso contrario
     */
    boolean existsByEmail(String email);
}
