package net.javaguides.ems.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * EmployeeServiceImpl
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicente@gmail.com
 * @version 07/09/2026 - 16:28
 * @since 1.25
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(final EmployeeDto employeeDto) {

        final Employee employee = EmployeeMapper.toEntity(employeeDto);
        final Employee savedEmployee = this.employeeRepository.save(employee);

        return EmployeeMapper.toDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(final Long employeeId) {

        final Employee employee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        return EmployeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        final List<Employee> employees = this.employeeRepository.findAll();

        return employees.stream().map(EmployeeMapper::toDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(final Long employeeId, final EmployeeDto employeeDto) {
        final Employee existingEmployee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());

        final Employee updatedEmployee = this.employeeRepository.save(existingEmployee);

        return EmployeeMapper.toDto(updatedEmployee);
    }

}
