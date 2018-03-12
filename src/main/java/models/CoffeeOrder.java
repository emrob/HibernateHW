package models;

import java.util.Set;

public class CoffeeOrder {

    private int id;
    private String type;
    private Set<Customer> customers;

    public CoffeeOrder() {}

    public CoffeeOrder(String type) { this.type = type; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}

