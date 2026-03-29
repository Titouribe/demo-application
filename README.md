# S40 - Evidencia de Aprendizaje Unidad 3: Taller práctico gestión de errores

Web application for employee management built with Spring Boot MVC, Thymeleaf, and H2 in-memory database.

---

## Overview

The application allows users to:

- List all registered employees
- Create new employees with duplicate email validation
- Edit existing employees
- Delete employees with confirmation modal
- View creation date and hourly salary per employee

---

## Project Structure

### Controller Layer
- `EmployeeCRUDController` – REST API for bulk operations
- `EmployeeViewController` – MVC controller for Thymeleaf views
- `EmployeeDTOMapper` – Maps between domain objects and DTOs
- `EmployeeCreationApi` – DTO for employee creation/update
- `EmployeeViewApi` – DTO for employee display

### Domain Layer
- `Employee` – Domain model
- `EmployeeService` – Service interface (Strategy pattern)
- `EmployeeServiceImpl` – Business logic with email validation

### Persistence Layer
- `EmployeeEntity` – JPA entity
- `EmployeeDatabaseService` – Persistence interface
- `EmployeeDatabaseServiceImpl` – Data access implementation
- `EmployeeMapper` – Maps between domain and JPA entity
- `EmployeeRepository` – Spring Data JPA repository

### Views
- `list-employees.html` – Employee list with edit/delete actions
- `add-edit-employee.html` – Create and edit form

---

## Architecture & Design

- MVC pattern separating controller, domain, and persistence layers
- Strategy pattern via `EmployeeService` interface decoupling business logic from implementation
- DTO pattern preventing direct exposure of domain and persistence models
- Java Streams API for email duplicate validation and data transformation
- Try-catch error handling in all controller and service operations
- Thymeleaf templates with dynamic form actions for create and edit

---

## Features

- Employee CRUD (Create, Read, Update, Delete)
- Duplicate email validation — stays on form with error message on conflict
- Delete confirmation modal
- Flash messages for success and error feedback
- Employee count badge on list view
- Hourly salary and creation date display

---

## Business Rules

- Email is required and must be unique across all employees
- On edit, email uniqueness excludes the employee being updated
- First name and last name are required fields
- Salary per hour must be greater than 0
- All errors are handled gracefully without application crash

---

## How to Run

1. Clone the repository:
```bash
   git clone <repository-url>
```

2. Build the project:
```bash
   mvn clean install
```

3. Run the application:
```bash
   mvn spring-boot:run
```

4. Open in browser:
```
   http://localhost:8080/demo-application/view/employee
```

---

## Technical Concepts Demonstrated

- Spring Boot MVC
- Strategy Design Pattern
- DTO Pattern
- Java Streams API and Lambdas
- JPA / Hibernate ORM
- H2 In-Memory Database
- Flyway Database Migrations
- Thymeleaf Template Engine
- Exception Handling with try-catch
- Bean Validation

---

## Limitations

- No authentication or authorization
- No pagination on employee list
- In-memory database (data lost on restart)
- No unit tests

---

## Authors

- **Jorge Eliecer Uribe Pulgarin** – [@titouribe](https://github.com/titouribe)
- **Luis Miguel Vargas Guevara** – [@luismvargasg](https://github.com/luismvargasg)
- **Manuel Ramiro Pemberthy Gil** – [@pemberth](https://github.com/pemberth)

---

## License

This project is intended for educational and academic purposes.