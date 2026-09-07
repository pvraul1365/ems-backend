package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - raul.perez.vicenet@gmail.com
 * @version 07/09/2026 - 16:14
 * @since 1.25
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
