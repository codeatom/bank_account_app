package manager.app.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import manager.app.data.CustomerIdSequencer;

class CustomerTest {

    @Test
    void should_Construct_A_Customer_Object_With_Expected_Fields() {
        //Arrange
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(firstName, lastName, email);
        int customerId = CustomerIdSequencer.readCustomerId();

        //Assert
        assertAll(
                () -> assertEquals(customerId, customer.getId()),
                () -> assertEquals(firstName, customer.getFirstName()),
                () -> assertEquals(lastName, customer.getLastName()),
                () -> assertEquals(email, customer.getEmail())
        );
    }

    @Test
    void should_Return_Customer_Id() {
        //Arrange
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(firstName, lastName, email);
        int customerId = CustomerIdSequencer.readCustomerId();

        //Assert
        assertEquals(customerId, customer.getId());
    }

    @Test
    void should_Return_Customer_FirstName() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(firstName, lastName, email);
        int customerId = CustomerIdSequencer.readCustomerId();

        //Assert
        assertEquals(firstName, customer.getFirstName());
    }

    @Test
    void should_Set_Customer_FirstName() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        String expectedFirstName = "Norah";

        //Act
        Customer customer = new Customer(firstName, lastName, email);
        customer.setFirstName(expectedFirstName);

        //Assert
        assertEquals(expectedFirstName, customer.getFirstName());
    }

    @Test
    void should_Return_Customer_LastName() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(firstName, lastName, email);

        //Assert
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    void should_Set_Customer_LastName() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        String expectedLastName = "Norah";

        //Act
        Customer customer = new Customer(firstName, lastName, email);
        customer.setLastName(expectedLastName);

        //Assert
        assertEquals(expectedLastName, customer.getLastName());
    }

    @Test
    void should_Return_Customer_Email() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(firstName, lastName, email);

        //Assert
        assertEquals(email, customer.getEmail());
    }

    @Test
    void should_Set_Customer_Email() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        String expectedEmail = "newEmail@email.com";

        //Act
        Customer customer = new Customer(firstName, lastName, email);
        customer.setEmail(expectedEmail);

        //Assert
        assertEquals(expectedEmail, customer.getEmail());
    }

    @Test
    void should_Return_Customer_AccountList() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        List<BankAccount> expectedAccountList = new ArrayList<>();

        //Act
        Customer customer = new Customer(firstName, lastName, email);

        //Assert
        assertEquals(expectedAccountList, customer.getBankAccountList());
    }

    @Test
    void should_Add_Bank_Account_To_Customer_AccountList() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        int customerId = 1;
        double accountBalance = 10;

        //Act
        Customer customer = new Customer(firstName, lastName, email);
        BankAccount bankAccount = new BankAccount(customerId, accountBalance);

        boolean accountAdded = customer.addAccountToList(bankAccount);

        //Assert
        assertTrue(accountAdded);
    }

    @Test
    void should_Remove_Bank_Account_From_Customer_AccountList() {
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        int customerId = 1;
        double accountBalance = 10;

        //Act
        Customer customer = new Customer(firstName, lastName, email);
        BankAccount bankAccount = new BankAccount(customerId, accountBalance);
        customer.addAccountToList(bankAccount);

        boolean accountRemoved = customer.removeAccountFromList(bankAccount);

        //Assert
        assertTrue(accountRemoved);
    }
}