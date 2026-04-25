class Manager extends FullTimeEmployee {
    private double TA;
    private double eduAllowance;

    public Manager(String name, String PANNo, String joiningDate, String designation,
                   int empId, double perfBonus, String role,
                   double TA, double eduAllowance) {
        super(name, PANNo, joiningDate, designation, empId, perfBonus, role);
        this.TA = TA;
        this.eduAllowance = eduAllowance;
    }

    @Override
    public double calcBenefits(Payroll p) {
        return super.calcBenefits(p) + TA + eduAllowance;
    }

    @Override
    public double calcCTC(Payroll p) {
        return super.calcCTC(p) + TA + eduAllowance; // cleaner
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee Type: Manager");
    }
}