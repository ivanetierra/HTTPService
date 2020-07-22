package payroll.controller;

import org.springframework.web.bind.annotation.*;
import payroll.Employee;
import payroll.EmployeeRepository;
import payroll.Role;

import java.util.List;
import java.util.Optional;

@RestController
class EmployeeController {

    public final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    //find by role
    @GetMapping("employees/role/{role}")
    Optional<List<Employee>> one(@PathVariable String role) {

        Optional<List<Employee>> listEmployeesByRole = Optional.ofNullable(repository.findByRole(Role.valueOf(role)).orElseThrow(() -> new EmployeeNotFoundException(role)));
        return listEmployeesByRole;
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    employee.setSalary(newEmployee.getSalary());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }


}