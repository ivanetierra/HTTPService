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

    public int getSalaryByRole() {
        return salary;
    }

}
