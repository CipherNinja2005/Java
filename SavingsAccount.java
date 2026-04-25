class SavingsAccount extends Account {

    public SavingsAccount(String accNo, double balance, Customer c) {
        super(accNo, balance, c);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < 1000) {
            System.out.println("Minimum balance 1000 required");
        } else {
            balance -= amount;
            customer.addTransaction("Savings Withdraw: " + amount);
        }
    }

    @Override
    public void display() {
        System.out.println("Savings Account: " + accNo + " Balance: " + balance);
    }
}