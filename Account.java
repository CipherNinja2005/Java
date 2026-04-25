abstract class Account {
    protected String accNo;
    protected double balance;
    protected Customer customer; 

    public Account(String accNo, double balance, Customer customer) {
        this.accNo = accNo;
        this.balance = balance;
        this.customer = customer;
    }

    public void deposit(double amount) {
        balance += amount;
        customer.addTransaction("Deposited " + amount + " in " + accNo);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            customer.addTransaction("Withdrawn " + amount + " from " + accNo);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public abstract void display();
}