package manager.app.data;

import java.util.ArrayList;
import java.util.List;
import manager.app.model.Customer;

public class CustomerDAO {
    private final List<Customer> customerList = new ArrayList<>();
    private final List<String> customerEmailList = new ArrayList<>();

    public List<Customer> getCustomerList() {
        return new ArrayList<>(customerList);
    }

    public List<String> getCustomerEmailList() {
        return new ArrayList<>(customerEmailList);
    }

    public void addCustomerToList(Customer customer) {
        customerList.add(customer);
    }

    public void addEmailToList(String email) {
        customerEmailList.add(email);
    }

    public void resetCustomerList() {
        customerList.clear();
    }

    public void resetCustomerEmailList() {
        customerEmailList.clear();
    }

    public Customer createCustomer(String firstName, String lastName, String email){
        Customer customer = new Customer(firstName, lastName, email);

        if(emailIsUnique(email)){
            customer.setEmail(email);
            customerEmailList.add(email);
        }
        else{
            customer.setEmail("email is missing");
        }

        return customer;
    }

    public boolean emailIsUnique(String email){
        return !(customerEmailList.contains(email));
    }

    public Customer searchById(int customerId){
        for (Customer customer : customerList) {
            if(customerId == customer.getId()){
                return customer;
            }
        }

        return null;
    }

    public boolean removeCustomerFromList(int customerId){
        for (Customer customer : customerList) {
            if(customerId == customer.getId()){
                return customerList.remove(customer);
            }
        }

        return false;
    }
}