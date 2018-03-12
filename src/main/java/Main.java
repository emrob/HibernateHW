import db.DBCustomer;
import models.Customer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Mark");
        DBCustomer.save(customer1);
        List<Customer> foundCustomer = DBCustomer.getCustomer();
    }
}
