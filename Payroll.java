class Payroll {
    private double insurance;
    private double healthInsurance;
    private double pf;
    private double baseSalary;
    private int pto;

    public Payroll(double baseSalary, double insurance, double healthInsurance, double pf, int pto) {
        this.baseSalary = baseSalary;
        this.insurance = insurance;
        this.healthInsurance = healthInsurance;
        this.pf = pf;
        this.pto = pto;
    }

    public double getInsurance() { return insurance; }
    public double getHealthInsurance() { return healthInsurance; }
    public double getPf() { return pf; }
    public double getBaseSalary() { return baseSalary; }
    public int getPto() { return pto; }
}