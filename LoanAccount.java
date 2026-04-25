class LoanAccount extends Account {

    public LoanAccount(String accNo, double balance, Customer c) {
        super(accNo, balance, c);
    }

    @Override
    public void deposit(double amount) {
        balance -= amount; // loan repayment
        customer.addTransaction("Loan repaid: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Cannot withdraw from Loan Account");
    }

    @Override
    public void display() {
        System.out.println("Loan Account: " + accNo + " Due: " + balance);
    }
}