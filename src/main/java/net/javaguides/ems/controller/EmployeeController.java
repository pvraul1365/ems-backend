package net.javaguides.ems.controller;

import java.net.URI;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
