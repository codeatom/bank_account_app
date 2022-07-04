package manager.app.model;

import manager.app.data.CustomerIdSequencer;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private final List<BankAccount> bankAccountList;

    public Customer(String firstName, String lastName, String email) {
        this.id = CustomerIdSequencer.nextCustomerId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        bankAccountList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BankAccount> getBankAccountList() {
        return new ArrayList<>(bankAccountList);
    }

    public boolean addAccountToList(BankAccount account){
        return this.bankAccountList.add(account);
    }

    public boolean removeAccountFromList(BankAccount account){
        return this.bankAccountList.remove(account);
    }

    public String getCustomerInformation(){
        return  "Customer id: " + this.id +"\n"
                + "First Name: " + this.firstName +"\n"
                + "Last Name: " + this.lastName +"\n"
                + "email: " + this.email +"\n";
    }

    @Override
    public String toString() {
        return getCustomerInformation();
    }

}