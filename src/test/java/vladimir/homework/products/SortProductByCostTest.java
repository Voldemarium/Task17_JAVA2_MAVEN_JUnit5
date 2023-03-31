package vladimir.homework.products;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class SortProductByCostTest {
    Product product1;
    Product product2;
    Product product3;

    @BeforeEach
    void setUp() {
       product1 = new Phone("Nokia-g10", 10_000, "Nokia");
       product2 = new Toy("Car", 1_000, 3);
       product3 = new Toy("Car", 1_000, 3);
    }

    @Test
    @DisplayName("Test for SortProductByCost")
    void compare() {
        SortProductByCost sortProductByCost = new SortProductByCost();
        int actually1 = sortProductByCost.compare(product1, product2);
        int actually2 = sortProductByCost.compare(product2, product3);
        int expected1 = 1;
        int expected2 = 0;
        assertEquals(expected1, actually1);
        assertEquals(expected2, actually2);

    }
}