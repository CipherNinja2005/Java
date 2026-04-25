public class Main_6 {
    public static void main(String[] args) {

        Payroll p = new Payroll(600000, 20000, 15000, 50000, 20);

        Employee emp1 = new FullTimeEmployee(
                "Kedar", "ABCDE1234F", "01-01-2022", "SWE", 101,
                50000, "SWE"
        );

        Employee emp2 = new ContractEmployee(
                "Shirin", "PQRSX5678L", "15-03-2023", "Consultant", 102,
                120, 800
        );

        Employee mgr = new Manager(
                "Vikram", "LMNOP9876Z", "10-05-2020", "Manager", 103,
                100000, "Manager",
                25000, 15000
        );

        Employee[] employees = {emp1, emp2, mgr};

        for (Employee e : employees) {
            e.displayDetails();
            System.out.println("CTC: " + e.calcCTC(p));
            System.out.println("-------------------------");
        }
    }
}