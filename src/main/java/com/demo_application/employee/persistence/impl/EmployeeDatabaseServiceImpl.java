package com.demo_application.employee.persistence.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.persistence.EmployeeDatabaseService;
import com.demo_application.employee.persistence.mapper.EmployeeMapper;
import com.demo_application.employee.persistence.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * Implementación del servicio de acceso a datos para empleados.
 * <p>
 * Realiza operaciones CRUD sobre la base de datos usando EmployeeRepository y
 * mapea entre entidades y dominio.
 * </p>
 */
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeDatabaseServiceImpl implements EmployeeDatabaseService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    /**
     * Obtiene todos los empleados desde la base de datos.
     * 
     * @return Lista de empleados de dominio
     */
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDomain)
                .toList();
    }

    /**
     * Guarda una colección de empleados en la base de datos.
     * 
     * @param employees Empleados de dominio a guardar
     * @return Lista de empleados guardados (dominio)
     */
    @Override
    public List<Employee> saveAll(Collection<Employee> employees) {
        return employees.stream()
                .map(employeeMapper::toEntity)
                .map(employeeRepository::save)
                .map(employeeMapper::toDomain)
                .toList();
    }

    /**
     * Elimina empleados por sus IDs.
     * 
     * @param ids Colección de IDs a eliminar
     */
    @Override
    public void deleteAllByIds(Collection<Long> ids) {
        employeeRepository.deleteAllById(ids);
    }

    /**
     * Verifica si existe un empleado con el email dado.
     * 
     * @param email Email a buscar
     * @return true si existe, false en caso contrario
     */
    @Override
    public boolean existsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }
}
