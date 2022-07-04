package manager.app.model;

import manager.app.data.AccountNumberSequencer;

public class BankAccount {
    private final int accountNumber;
    private final int customerId;
    private double balance;

    public BankAccount(int customerId, double balance) {
        this.accountNumber = AccountNumberSequencer.nextAccountNumber();
        this.customerId = customerId;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountInformation(){
        return "accountNumber: " + accountNumber + "\n"
                + " balance: " + balance + "\n"
                + "customerId: " + customerId;
    }

    public double depositFund(double fund){
        setBalance(balance + fund);

        return balance;
    }

    public double withdraw(double fund) throws IllegalArgumentException{
        if(balance >= fund){
            setBalance(balance - fund);
        }
        else{
            System.out.println("Your balance is not to enough for the request");
            throw new IllegalArgumentException();
        }

        return  balance;
    }
}