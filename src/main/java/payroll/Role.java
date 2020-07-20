package payroll;

public enum Role {
    burglar("burglar", 100),
    thief("thief", 150),
    boss("boss", 350);

    private String role;
    private int salary;

    private Role(String role, int salary) {
        this.role = role;
        this.salary = salary;
    }

    public int getSalaryRole() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
