import java.util.*;

public class BankingApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account to Customer");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Add Nominee");
            System.out.println("6. View Transactions");
            System.out.println("7. Display Customers");
            System.out.println("0. Exit");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                //Add Customer
                case 1:
                    System.out.print("Enter Customer ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    Customer c = new Customer(id, name);

                    System.out.print("Enter PAN: ");
                    c.setPan(sc.nextLine());

                    System.out.print("Enter Aadhar: ");
                    c.setAadhar(sc.nextLine());

                    customers.add(c);
                    break;

                //Add Account
                case 2:
                    Customer cust = findCustomer(customers, sc);
                    if (cust == null) break;

                    System.out.println("1. Savings  2. Loan");
                    int type = sc.nextInt();

                    System.out.print("Enter Account No: ");
                    String accNo = sc.next();

                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    if (type == 1)
                        cust.addAccount(new SavingsAccount(accNo, bal, cust));
                    else
                        cust.addAccount(new LoanAccount(accNo, bal, cust));

                    break;

                //Deposit
                case 3:
                    Account acc1 = findAccount(customers, sc);
                    if (acc1 != null) {
                        System.out.print("Amount: ");
                        acc1.deposit(sc.nextDouble());
                    }
                    break;

                //Withdraw
                case 4:
                    Account acc2 = findAccount(customers, sc);
                    if (acc2 != null) {
                        System.out.print("Amount: ");
                        acc2.withdraw(sc.nextDouble());
                    }
                    break;

                //Add Nominee
                case 5:
                    Customer cust2 = findCustomer(customers, sc);
                    if (cust2 != null) {
                        System.out.print("Enter nominee: ");
                        cust2.addNominee(sc.nextLine());
                    }
                    break;

                //View Transactions
                case 6:
                    Customer cust3 = findCustomer(customers, sc);
                    if (cust3 != null)
                        cust3.viewTxnHistory();
                    break;

                //Display All
                case 7:
                    for (Customer customer : customers)
                        customer.display();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }

    //Find Customer
    static Customer findCustomer(List<Customer> customers, Scanner sc) {
        System.out.print("Enter Customer ID: ");
        String id = sc.nextLine();

        for (Customer c : customers) {
            if (c.getCustId().equals(id))
                return c;
        }

        System.out.println("Customer not found");
        return null;
    }

    //Find Account
    static Account findAccount(List<Customer> customers, Scanner sc) {
        System.out.print("Enter Account No: ");
        String accNo = sc.nextLine();

        for (Customer c : customers) {
            for (Account a : c.getAccounts()) {
                if (a.accNo.equals(accNo))
                    return a;
            }
        }

        System.out.println("Account not found");
        return null;
    }
}