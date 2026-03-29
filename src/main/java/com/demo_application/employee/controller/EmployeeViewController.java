package com.demo_application.employee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo_application.employee.controller.dto.EmployeeCreationApi;
import com.demo_application.employee.controller.dto.EmployeeViewApi;
import com.demo_application.employee.controller.mapper.EmployeeDTOMapper;
import com.demo_application.employee.domain.model.Employee;
import com.demo_application.employee.domain.service.EmployeeService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador MVC para la gestión de empleados en vistas web.
 * <p>
 * Permite listar, crear, editar y eliminar empleados usando plantillas
 * Thymeleaf.
 * </p>
 */
@Controller
@RequestMapping("/view/employee")
@RequiredArgsConstructor
public class EmployeeViewController {

    private final EmployeeService employeeService;
    private final EmployeeDTOMapper employeeDtoMapper;

    /**
     * Muestra la lista de empleados en la vista principal.
     * 
     * @param model Modelo de la vista
     * @return Nombre de la plantilla Thymeleaf
     */
    @GetMapping
    public String listAll(Model model) {
        try {
            List<EmployeeViewApi> employees = employeeService.findAll()
                    .stream()
                    .map(employeeDtoMapper::toDto)
                    .toList();

            model.addAttribute("employees", employees);
            model.addAttribute("totalCount", employees.size());
            model.addAttribute("newEmployee", new EmployeeCreationApi());

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al cargar empleados: " + e.getMessage());
            model.addAttribute("employees", List.of());
            model.addAttribute("newEmployee", new EmployeeCreationApi());
        }

        return "list-employees";
    }

    /**
     * Muestra el formulario para crear un nuevo empleado.
     * 
     * @param model Modelo de la vista
     * @return Nombre de la plantilla de formulario
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        if (!model.containsAttribute("employee")) {
            model.addAttribute("employee", new EmployeeCreationApi());
        }
        return "add-edit-employee";
    }

    /**
     * Procesa la creación de un nuevo empleado.
     * 
     * @param dto   DTO con los datos del empleado
     * @param model Modelo de la vista
     * @return Redirección o plantilla de formulario en caso de error
     */
    @PostMapping("/new")
    public String createEmployee(@ModelAttribute("employee") EmployeeCreationApi dto,
            Model model) {
        try {
            if (dto.getFirstName() == null || dto.getFirstName().isBlank()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }
            if (dto.getLastName() == null || dto.getLastName().isBlank()) {
                throw new IllegalArgumentException("El apellido no puede estar vacío");
            }

            Employee domain = employeeDtoMapper.toDomain(dto);
            employeeService.saveAll(List.of(domain));

            return "redirect:/view/employee";

        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("employee", dto);
            return "add-edit-employee";

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error inesperado: " + e.getMessage());
            model.addAttribute("employee", dto);
            return "add-edit-employee";
        }
    }

    /**
     * Elimina un empleado por su ID.
     * 
     * @param id                 ID del empleado a eliminar
     * @param redirectAttributes Atributos para mensajes flash
     * @return Redirección a la lista de empleados
     */
    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long id,
            RedirectAttributes redirectAttributes) {
        try {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException("ID inválido para eliminar");
            }

            employeeService.deleteAllByIds(List.of(id));
            redirectAttributes.addFlashAttribute("successMessage",
                    "Empleado con ID " + id + " eliminado correctamente.");

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Error al eliminar: " + e.getMessage());
        }

        return "redirect:/view/employee";
    }

    /**
     * Muestra el formulario para editar un empleado existente.
     * 
     * @param id    ID del empleado
     * @param model Modelo de la vista
     * @return Nombre de la plantilla de formulario o redirección en caso de error
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            Employee emp = employeeService.findAll().stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));
            model.addAttribute("employee", employeeDtoMapper.toCreationDto(emp));
            return "add-edit-employee";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "redirect:/view/employee";
        }
    }

    /**
     * Procesa la actualización de un empleado existente.
     * 
     * @param dto   DTO con los datos actualizados
     * @param model Modelo de la vista
     * @return Redirección o plantilla de formulario en caso de error
     */
    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute("employee") EmployeeCreationApi dto, Model model) {
        try {
            Employee domain = employeeDtoMapper.toDomain(dto);
            employeeService.saveAll(List.of(domain));
            return "redirect:/view/employee";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("employee", dto);
            return "add-edit-employee";
        }
    }
}