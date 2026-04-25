import java.util.*;

class Customer {
    private String custId, name, pan, aadhar, address;
    private List<String> nominees = new ArrayList<>();
    private List<String> transactions = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    public Customer(String custId, String name) {
        this.custId = custId;
        this.name = name;
    }

    //Setters
    public void setPan(String pan) { this.pan = pan; }
    public void setAadhar(String aadhar) { this.aadhar = aadhar; }
    public void setAddress(String address) { this.address = address; }

    public String getCustId() {
    return custId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    //Functions from your PHOTO
    public void addNominee(String nominee) {
        nominees.add(nominee);
    }

    public void viewTxnHistory() {
        for (String t : transactions)
            System.out.println(t);
    }

    public double checkCredit() {
        return accounts.size() * 100; // dummy logic
    }

    public void updateDetails(String address) {
        this.address = address;
    }

    //Link accounts
    public void addAccount(Account acc) {
    accounts.add(acc);
    System.out.println("Account added successfully!");
}

    //Record transactions from accounts
    public void addTransaction(String t) {
        transactions.add(t);
    }

    public void display() {
        System.out.println("\nCustomer: " + name);
        System.out.println("PAN: " + pan);
        System.out.println("Aadhar: " + aadhar);

        for (Account acc : accounts) {
            acc.display();
        }
    }
}