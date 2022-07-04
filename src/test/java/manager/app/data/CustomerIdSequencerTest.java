package manager.app.data;

import manager.app.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerIdSequencerTest {

    @Test
    void Should_Return_Sequential_int() {
        //Arrange
        int expectedId = 4;

        //Act
        CustomerIdSequencer.nextCustomerId();
        CustomerIdSequencer.nextCustomerId();
        CustomerIdSequencer.nextCustomerId();
        CustomerIdSequencer.nextCustomerId();

        //Assert
        assertEquals(expectedId, CustomerIdSequencer.readCustomerId());
    }

    @Test
    void should_Reset_Customer_Id_To_Zero() {
        //Arrange
        int expectedId = 0;

        //Act
        CustomerIdSequencer.nextCustomerId();
        CustomerIdSequencer.nextCustomerId();
        CustomerIdSequencer.nextCustomerId();
        CustomerIdSequencer.nextCustomerId();

        CustomerIdSequencer.resetCustomerId();

        //Assert
        assertEquals(expectedId, CustomerIdSequencer.readCustomerId());
    }

    @Test
    void Should_Read_And_Return_Customer_Id() {
        //Arrange
        int expectedId = 3;
        CustomerIdSequencer.resetCustomerId();

        //Act
        CustomerIdSequencer.nextCustomerId();
        CustomerIdSequencer.nextCustomerId();
        CustomerIdSequencer.nextCustomerId();

        //Assert
        assertEquals(expectedId, CustomerIdSequencer.readCustomerId());
    }
}