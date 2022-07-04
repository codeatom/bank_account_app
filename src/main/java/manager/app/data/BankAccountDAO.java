package manager.app.data;

import manager.app.model.BankAccount;
import manager.app.model.Customer;
import manager.app.data.CustomerDAO;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO {
    private final List<BankAccount> bankAccountList = new ArrayList<>();

    public List<BankAccount> getBankAccountList() {
        return new ArrayList<>(bankAccountList);
    }

    public void addBankAccountToList(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

  //  public void resetBankAccountList() {
  //      bankAccountList.clear();
  //  }

    public BankAccount createBankAccount(Customer customer, double balance, CustomerDAO customerDAO, BankAccountDAO bankAccountDAO){
        BankAccount bankAccount = new BankAccount(customer.getId(), balance);

        customer.addAccountToList(bankAccount);

        customerDAO.addCustomerToList(customer);
        bankAccountDAO.addBankAccountToList(bankAccount);

        return bankAccount;
    }

    public BankAccount searchByAccountNumber(int accNumber){
        for (BankAccount bankAccount : bankAccountList) {
            if(accNumber == bankAccount.getAccountNumber()){
                return bankAccount;
            }
        }

        return null;
    }

    public boolean removeAccountFromList(int accNumber){
        for (BankAccount bankAccount : bankAccountList) {
            if(accNumber == bankAccount.getAccountNumber()){
                return bankAccountList.remove(bankAccount);
            }
        }

        return false;
    }

    public boolean closeAccount(Customer customer, int accNumber){
        for (BankAccount bankAccount : customer.getBankAccountList()) {
            if(accNumber == bankAccount.getAccountNumber()){
                bankAccount.withdraw(bankAccount.getBalance());

                customer.removeAccountFromList(bankAccount);
                bankAccountList.remove(bankAccount);

                return true;
            }
        }

        return false;
    }

}