package manager.app.data;

public class AccountNumberSequencer {
    private static final int bankNumber = 10000;
    private static int accountNumber = bankNumber;

    public static int readBankNumber() {
        return bankNumber;
    }

    public static int nextAccountNumber(){
        return  ++accountNumber;
    }

    public static int readAccountNumber() {
        return accountNumber;
    }

    public static int resetAccountNumber(){
        return accountNumber = 0;
    } //For testing purpose only.
}