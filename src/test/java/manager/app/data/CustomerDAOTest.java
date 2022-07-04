package manager.app.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import manager.app.model.Customer;

class CustomerDAOTest {
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
        customerDAO.addEmailToList("A@email.com");
        customerDAO.addEmailToList("B@email.com");
        customerDAO.addEmailToList("C@email.com");
        customerDAO.addEmailToList("D@email.com");
        customerDAO.addEmailToList("E@email.com");

        boolean emailIsValid = customerDAO.emailIsUnique("uniqueEmail@email.com");

        //Assert
        assertTrue(emailIsValid);
    }

    @Test
    void should_Return_False_When_Customer_Email_Is_Not_Unique() {
        //Arrange

        //Act
        customerDAO.addEmailToList("A@email.com");
        customerDAO.addEmailToList("B@email.com");
        customerDAO.addEmailToList("C@email.com");
        customerDAO.addEmailToList("D@email.com");
        customerDAO.addEmailToList("nonUnique@email.com");

        boolean emailIsValid = customerDAO.emailIsUnique("nonUnique@email.com");

        //Assert
        assertFalse(emailIsValid);
    }

    @Test
    void should_Return_A_Customer_With_A_Given_Id() {
        //Arrange
        Customer customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        //Act
        customerDAO.addCustomerToList(customer1);
        customerDAO.addCustomerToList(customer2);
        customerDAO.addCustomerToList(customer3);

        Customer expectedCustomer = customerDAO.searchById(customer3.getId());

        // Assert
        assertEquals(customer3, expectedCustomer);
    }

    @Test
    void should_Return_Null_When_Id_Is_Not_Valid() {
        //Arrange
        Customer customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        //Act
        customerDAO.addCustomerToList(customer1);
        customerDAO.addCustomerToList(customer2);
        customerDAO.addCustomerToList(customer3);

        Customer expectedCustomer = customerDAO.searchById(100);

        // Assert
        assertNull(expectedCustomer);
    }

    @Test
    void should_Remove_A_Customer_With_A_Given_Id() {
        //Arrange
        Customer customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        //Act
        customerDAO.addCustomerToList(customer1);
        customerDAO.addCustomerToList(customer2);
        customerDAO.addCustomerToList(customer3);

        boolean customerRemoved = customerDAO.removeCustomerFromList(customer2.getId());

        // Assert
        assertTrue(customerRemoved);
    }

    @Test
    void should_Not_Remove_A_Customer_When_Id_Is_Invalid() {
        //Arrange
        Customer customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        //Act
        customerDAO.addCustomerToList(customer1);
        customerDAO.addCustomerToList(customer2);
        customerDAO.addCustomerToList(customer3);

        boolean customerRemoved = customerDAO.removeCustomerFromList(100);

        // Assert
        assertFalse(customerRemoved);
    }
}