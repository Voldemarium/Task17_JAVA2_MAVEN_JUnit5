package vladimir.homework.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;
    Product product1;
    Product product2;

    @BeforeEach
    void setUp() {
        product = new Product("Nokia", 10);
        product1 = new Product("Nokia", 10);
        product2 = new Product("Food", 20);
    }

    @Test
    void testEquals() {
        boolean condition1 = product.equals(product1);
        assertTrue(condition1);
        boolean condition2 = product.equals(product2);
        assertFalse(condition2);
    }
}