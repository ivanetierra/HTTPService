package payroll.controller;

import payroll.Role;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }

    EmployeeNotFoundException(String role) {
        super("Could not find employee " + role);
    }
}