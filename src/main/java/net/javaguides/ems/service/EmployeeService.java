package net.javaguides.ems.service;

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

}
