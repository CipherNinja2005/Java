abstract class Employee {
    protected String name, PANNo, joiningDate, designation;
    protected int empId;

    public Employee(String name, String PANNo, String joiningDate, String designation, int empId) {
        this.name = name;
        this.PANNo = PANNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    public abstract double calcCTC(Payroll p);
    public abstract double calcBenefits(Payroll p);

    public void displayDetails() {
        System.out.println("\nEmployee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("PAN: " + PANNo);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Designation: " + designation);
    }
}