package manager.app.data;

import manager.app.model.BankAccount;
import manager.app.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountDAOTest {
    CustomerDAO customerDAO;
    BankAccountDAO bankAccountDAO;

    @BeforeEach
    void setup(){
        customerDAO = new CustomerDAO();
        bankAccountDAO = new BankAccountDAO();
        AccountNumberSequencer.resetAccountNumber();
        CustomerIdSequencer.resetCustomerId();
    }

    @Test
    void should_Create_A_Bank_Account() {
        //Arrange
        double balance = 30;

        //Act
        Customer customer = new Customer("Christopher", "Lucky", "cl@email.com");
        bankAccountDAO.createBankAccount(customer, balance, customerDAO, bankAccountDAO);

        BankAccount expectedBankAccount = bankAccountDAO.getBankAccountList().get(0);
        int expectedAccountNumber = AccountNumberSequencer.readAccountNumber();
        int expectedCustomerId = CustomerIdSequencer.readCustomerId();

        //Assert
        assertEquals(expectedAccountNumber, expectedBankAccount.getAccountNumber());
        assertEquals(expectedCustomerId, expectedBankAccount.getCustomerId());
        assertEquals(balance, expectedBankAccount.getBalance());
    }

    @Test
    void should_Return_A_Bank_Account_With_A_Given_Id() {
        //Arrange
        BankAccount bankAccount1 = new BankAccount(1, 10);
        BankAccount bankAccount2 = new BankAccount(2, 20);
        BankAccount bankAccount3 = new BankAccount(3, 30);

        //Act
        bankAccountDAO.addBankAccountToList(bankAccount1);
        bankAccountDAO.addBankAccountToList(bankAccount2);
        bankAccountDAO.addBankAccountToList(bankAccount3);

        BankAccount expectedBankAccount = bankAccountDAO.searchByAccountNumber(bankAccount2.getAccountNumber());

        // Assert
        assertEquals(bankAccount2, expectedBankAccount);
    }

    @Test
    void should_Return_Null_When_Account_Number_Is_Not_Valid() {
        ///Arrange
        BankAccount bankAccount1 = new BankAccount(1, 10);
        BankAccount bankAccount2 = new BankAccount(2, 20);
        BankAccount bankAccount3 = new BankAccount(3, 30);

        //Act
        bankAccountDAO.addBankAccountToList(bankAccount1);
        bankAccountDAO.addBankAccountToList(bankAccount2);
        bankAccountDAO.addBankAccountToList(bankAccount3);

        BankAccount expectedBankAccount = bankAccountDAO.searchByAccountNumber(5);

        // Assert
        assertNull(expectedBankAccount);
    }

    @Test
    void should_Remove_A_Bank_Account_With_A_Given_Account_Number() {
        ///Arrange
        BankAccount bankAccount1 = new BankAccount(1, 10);
        BankAccount bankAccount2 = new BankAccount(2, 20);
        BankAccount bankAccount3 = new BankAccount(3, 30);

        //Act
        bankAccountDAO.addBankAccountToList(bankAccount1);
        bankAccountDAO.addBankAccountToList(bankAccount2);
        bankAccountDAO.addBankAccountToList(bankAccount3);

        boolean accountRemoved = bankAccountDAO.removeAccountFromList(bankAccount3.getAccountNumber());

        // Assert
        assertTrue(accountRemoved);
    }

    @Test
    void should_Not_Remove_A_Bank_Account_When_A_Given_Account_Number_Is_Invalid() {
        ///Arrange
        BankAccount bankAccount1 = new BankAccount(1, 10);
        BankAccount bankAccount2 = new BankAccount(2, 20);
        BankAccount bankAccount3 = new BankAccount(3, 30);

        //Act
        bankAccountDAO.addBankAccountToList(bankAccount1);
        bankAccountDAO.addBankAccountToList(bankAccount2);
        bankAccountDAO.addBankAccountToList(bankAccount3);

        boolean accountRemoved = bankAccountDAO.removeAccountFromList(8);

        // Assert
        assertFalse(accountRemoved);
    }

    @Test
    void should_Remove_A_Bank_Account_From_Customer_AccountList_And_CustomerDAO_AccountList() {
        ///Arrange
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        BankAccount bankAccount = new BankAccount(1, 10);


        //Act
        Customer customer = new Customer(firstName, lastName, email);

        customer.addAccountToList(bankAccount);
        bankAccountDAO.addBankAccountToList(bankAccount);

        boolean accountRemoved = bankAccountDAO.closeAccount(customer, bankAccount.getAccountNumber());

        // Assert
        assertTrue(accountRemoved);
    }
}