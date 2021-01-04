package codetest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.AfterAll; // could be practical if have more test methods
// import org.junit.jupiter.api.AfterEach; // could be practical if have more test methods
// import org.junit.jupiter.api.BeforeAll; // could be practical if have more test methods
// import org.junit.jupiter.api.BeforeEach; // could be practical if have more test methods

import java.util.ArrayList;
import java.util.List;


public class CalculateTest {

    /**
     * Test of calculateMonthlyPayment method, of class Calculate
     */
    @Test
    public void testCalculateMonthlyPayment() {

        System.out.println("Testing calculate monthly payment");

        // prepare testing material
        Customer customer1 = new Customer("Juha", 1000.0, 5.0, 2);
        Customer customer2 = new Customer("Karvinen", 4356.0, 1.27, 6);
        Customer customer3 = new Customer("Claes Månsson", 1300.55, 8.67, 2);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        // prepare to test method
        Calculate calculator = new Calculate();
        calculator.calculateMonthlyPayment(customers);

        // test
        assertEquals(43.8713897340686, customer1.getMonthlyPayment());
        assertEquals(62.86631476623255, customer2.getMonthlyPayment());
        assertEquals(59.21856882868132, customer3.getMonthlyPayment());

        System.out.println("End of test for calculate monthly payment");
    } 
}
