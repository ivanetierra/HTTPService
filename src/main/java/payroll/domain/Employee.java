package payroll.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public
class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private Role role;  //las faenas son fijas
    private int salary;

    Employee() {}

    public Employee(String name, Role role) {

        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Role getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) { this.role = role; }

    //setter y getter de salary
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return role.getSalaryRole();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "idaaaa=" + this.id + ", name=" + this.name + '\''
                + ", role=" + this.role + '\'' + ", salary=" + this.salary + '}';
    }
}