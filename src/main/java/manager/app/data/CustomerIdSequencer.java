package manager.app.data;

public class CustomerIdSequencer {
    private static int customerId = 0;

    public static int nextCustomerId(){
        return ++customerId;
    }

    public static int readCustomerId() {
        return customerId;
    }

    public static int resetCustomerId(){
        return customerId = 0;
    } //For testing purpose only.
}