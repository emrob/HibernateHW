import models.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    public Customer customer;

    @Before
    public void before(){
        customer = new Customer("Mark");
    }

    @Test
    public void hasName(){
        assertEquals("Mark", customer.getName());
    }
}
