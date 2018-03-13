import db.DBHelper;
import models.CoffeeOrder;
import models.Customer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CoffeeOrder coffeeOrder1 = new CoffeeOrder("Soy Latte");
        DBHelper.save(coffeeOrder1);
        CoffeeOrder coffeeOrder2 = new CoffeeOrder("Americano");
        DBHelper.save(coffeeOrder2);
        CoffeeOrder coffeeOrder3 = new CoffeeOrder("Flat white");
        DBHelper.save(coffeeOrder3);
        Customer customer1 = new Customer("Mark",coffeeOrder1);
        DBHelper.save(customer1);
        Customer customer2 = new Customer("Emma",coffeeOrder2);
        DBHelper.save(customer2);
        Customer customer3 = new Customer("Will",coffeeOrder2);
        DBHelper.save(customer3);

        customer1.setCoffeeOrder(coffeeOrder3);
        DBHelper.update(customer1);

        List<Customer> foundCustomers = DBHelper.getAll("Customer");
        List<CoffeeOrder> foundCoffeeOrders = DBHelper.getAll("CoffeeOrder");

        Customer foundCustomer = DBHelper.getObjectByID("Customer", customer1.getId());

    }
}
