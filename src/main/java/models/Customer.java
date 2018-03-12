package models;

public class Customer {
    private int id;
    private String name;
    private CoffeeOrder coffeeOrder;

    public Customer() {}

    public Customer(String name, CoffeeOrder coffeeOrder) {
        this.name = name;
        this.coffeeOrder = coffeeOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoffeeOrder getCoffeeOrder() {
        return coffeeOrder;
    }

    public void setCoffeeOrder(CoffeeOrder coffeeOrder) {
        this.coffeeOrder = coffeeOrder;
    }
}
