package manager.app.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountNumberSequencerTest {

    @Test
    void Should_Return_Sequential_int() {
        //Arrange
        int bankBranchNumber = AccountNumberSequencer.readBankBranchNumber();
        int expectedId = bankBranchNumber + 4;

        //Act
        AccountNumberSequencer.nextAccountNumber();
        AccountNumberSequencer.nextAccountNumber();
        AccountNumberSequencer.nextAccountNumber();
        AccountNumberSequencer.nextAccountNumber();

        //Assert
        assertEquals(expectedId, AccountNumberSequencer.readAccountNumber());
    }

    @Test
    void should_Reset_Account_Id_To_Zero() {
        //Arrange
        int expectedId = 0;

        //Act
        AccountNumberSequencer.nextAccountNumber();
        AccountNumberSequencer.nextAccountNumber();
        AccountNumberSequencer.nextAccountNumber();
        AccountNumberSequencer.nextAccountNumber();

        AccountNumberSequencer.resetAccountNumber();

        //Assert
        assertEquals(expectedId, AccountNumberSequencer.readAccountNumber());
    }

    @Test
    void Should_Read_And_Return_Account_Id() {
        //Arrange
        int expectedId = 3;
        AccountNumberSequencer.resetAccountNumber();

        //Act
        AccountNumberSequencer.nextAccountNumber();
        AccountNumberSequencer.nextAccountNumber();
        AccountNumberSequencer.nextAccountNumber();

        //Assert
        assertEquals(expectedId, AccountNumberSequencer.readAccountNumber());
    }

}