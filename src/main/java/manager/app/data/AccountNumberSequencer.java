package manager.app.data;

public class AccountNumberSequencer {
    private static final int bankBranchNumber = 10000;
    private static int accountNumber = bankBranchNumber;

    public static int readBankBranchNumber() {
        return bankBranchNumber;
    }

    public static int readAccountNumber() {
        return accountNumber;
    }

    public static int nextAccountNumber(){
        return  ++accountNumber;
    }

    public static int resetAccountNumber(){
        return accountNumber = 0;
    }
}