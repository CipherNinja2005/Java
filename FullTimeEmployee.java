class FullTimeEmployee extends Employee {
    protected double perfBonus;
    protected String role;

    public FullTimeEmployee(String name, String PANNo, String joiningDate, String designation,
                            int empId, double perfBonus, String role) {
        super(name, PANNo, joiningDate, designation, empId);
        this.perfBonus = perfBonus;
        this.role = role;
    }

    public double calcBenefits(Payroll p) {
        return p.getInsurance() + p.getHealthInsurance() + p.getPf();
    }

    public double calcCTC(Payroll p) {
        return p.getBaseSalary() + perfBonus + calcBenefits(p);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: " + role);
        System.out.println("Employee Type: Full-Time");
    }
}