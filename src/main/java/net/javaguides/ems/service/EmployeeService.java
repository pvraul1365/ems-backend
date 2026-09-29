package net.javaguides.ems.service;

import java.util.List;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

/**
 * EmployeeService
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicenet@gmail.com
 * @version 07/09/2026 - 16:27
 * @since 1.25
 */
public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);
}
