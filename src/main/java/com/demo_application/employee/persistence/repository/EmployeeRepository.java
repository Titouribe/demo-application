package com.demo_application.employee.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo_application.employee.persistence.entity.EmployeeEntity;

/**
 * Repositorio JPA para la entidad EmployeeEntity.
 * <p>
 * Proporciona métodos para acceder y consultar empleados en la base de datos.
 * </p>
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    /**
     * Busca un empleado por su email.
     * 
     * @param email Email a buscar
     * @return Optional con el empleado si existe
     */
    Optional<EmployeeEntity> findByEmail(String email);

    /**
     * Verifica si existe un empleado con el email dado.
     * 
     * @param email Email a buscar
     * @return true si existe, false en caso contrario
     */
    boolean existsByEmail(String email);
}
