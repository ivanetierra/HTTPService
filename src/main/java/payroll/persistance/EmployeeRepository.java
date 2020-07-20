package payroll.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}