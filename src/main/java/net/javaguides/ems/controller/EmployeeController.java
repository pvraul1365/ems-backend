package net.javaguides.ems.controller;

import java.net.URI;
import java.util.List;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeController
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 07/09/2026 - 16:32
 * @since 1.25
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody final EmployeeDto employeeDto) {
        final EmployeeDto createdEmployee = this.employeeService.createEmployee(employeeDto);

        return ResponseEntity.created(URI.create("/api/employees/" + createdEmployee.getId()))
                .body(createdEmployee);
    }

    @GetMapping("/{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable final Long id) {
        final EmployeeDto employeeDto = this.employeeService.getEmployeeById(id);

        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @GetMapping
    ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        final List<EmployeeDto> employees = this.employeeService.getAllEmployees();

        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PutMapping("/{id}")
    ResponseEntity<EmployeeDto> updateEmployee(@PathVariable final Long id,
                                               @RequestBody final EmployeeDto employeeDto) {
        final EmployeeDto updatedEmployee = this.employeeService.updateEmployee(id, employeeDto);

        return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable final Long id) {
        this.employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }

}
