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
        Customer customer1 = new Customer("Mark",coffeeOrder1);
        DBHelper.save(customer1);
        Customer customer2 = new Customer("Emma",coffeeOrder2);
        DBHelper.save(customer2);

        List<Customer> customers = DBHelper.getAll("Customer");
        List<CoffeeOrder> coffeeOrders = DBHelper.getAll("CoffeeOrder");
    }
}
