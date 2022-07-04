package manager.app.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import manager.app.model.Customer;

class CustomerDAOTest {
    CustomerDAO customerDAO;
    BankAccountDAO bankAccountDAO;
    Customer customer1;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    void setup(){
        AccountNumberSequencer.resetAccountNumber();
        CustomerIdSequencer.resetCustomerId();

        customerDAO = new CustomerDAO();

        customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        customerDAO.addCustomerToList(customer1);
        customerDAO.addCustomerToList(customer2);
        customerDAO.addCustomerToList(customer3);

        customerDAO.addEmailToList("A@email.com");
        customerDAO.addEmailToList("B@email.com");
        customerDAO.addEmailToList("C@email.com");
        customerDAO.addEmailToList("D@email.com");
        customerDAO.addEmailToList("E@email.com");
        customerDAO.addEmailToList("nonUnique@email.com");
    }

    @Test
    void should_Create_A_CreateCustomer() {
        //Arrange
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = customerDAO.createCustomer(firstName, lastName, email);

        //Assert
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(email, customer.getEmail());
    }

    @Test
    void should_Return_True_When_Customer_Email_Is_Unique() {
        //Arrange

        //Act
        boolean emailIsValid = customerDAO.emailIsUnique("uniqueEmail@email.com");

        //Assert
        assertTrue(emailIsValid);
    }

    @Test
    void should_Return_False_When_Customer_Email_Is_Not_Unique() {
        //Arrange

        //Act
        boolean emailIsValid = customerDAO.emailIsUnique("nonUnique@email.com");

        //Assert
        assertFalse(emailIsValid);
    }

    @Test
    void should_Return_A_Customer_With_A_Given_Id() {
        //Arrange

        //Act
        Customer expectedCustomer = customerDAO.searchById(customer3.getId());

        // Assert
        assertEquals(customer3, expectedCustomer);
    }

    @Test
    void should_Return_Null_When_Id_Is_Not_Valid() {
        //Arrange

        //Act
        Customer expectedCustomer = customerDAO.searchById(100);

        // Assert
        assertNull(expectedCustomer);
    }

    @Test
    void should_Remove_A_Customer_With_A_Given_Id() {
        //Arrange

        //Act
        boolean customerRemoved = customerDAO.removeCustomerFromList(customer2.getId());

        // Assert
        assertTrue(customerRemoved);
    }

    @Test
    void should_Not_Remove_A_Customer_When_Id_Is_Invalid() {
        //Arrange

        //Act
        boolean customerRemoved = customerDAO.removeCustomerFromList(100);

        // Assert
        assertFalse(customerRemoved);
    }
}