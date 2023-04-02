package vladimir.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vladimir.homework.products.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    Shop shop = new Shop();
    TreeMap<Product, Integer> products = new TreeMap<>(new SortProductByCost());
    Product product1;
    Product product2;
    Product product3;
    Product product4;
    Product product5;
    Product product6;
    Product product7;

    @BeforeEach
    void setUp() {
        product1 = new Food("Cheese", 400, new GregorianCalendar(2023, Calendar.JANUARY, 12));
        product2 = new Food("Milk", 50, 2023, 1, 5);
        product3 = new Phone("Nokia-g10", 10_000, "Nokia");
        product4 = new Phone("Samsung-s20", 20_000, "Samsung");
        product5 = new Toy("Car", 1_000, 3);
        product6 = new Toy("Barby", 1_400, 5);
        product7 = new Toy("Car", 2_000, 7);
        products.put(product1, 2);
        products.put(product2, 2);
        products.put(product3, 4);
        products.put(product4, 4);
        products.put(product5, 4);
        products.put(product6, 4);
        shop.setProducts(products);
    }

    @Test
    @DisplayName("add Product")
    void addProduct() {
        Shop actual1 = shop.addProduct(product7, 1);
        products.put(product7, 1);
        shop.setProducts(products);
        Shop expected1 = shop;
        Assertions.assertEquals(expected1, actual1);

        Shop actual2 = shop.addProduct(product1, 3);
        products.put(product1, 3);
        shop.setProducts(products);
        Shop expected2 = shop;
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    @DisplayName("delete Product")
    void deleteProduct() {
        shop.deleteProduct(product1.getName(), shop.getProducts().get(product1));
        Shop actual1 = shop;
        products.remove(product1);
        shop.setProducts(products);
        Shop expected1 = shop;
        Assertions.assertEquals(expected1, actual1);

        shop.deleteProduct(product2.getName(), 1);
        Shop actual2 = shop;
        products.put(product2, 1);
        shop.setProducts(products);
        Shop expected2 = shop;
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    @DisplayName("size")
    void size() {
        int actual = shop.size();
        assertEquals(6, actual);
    }

    @Test
    void getProducts() {
        Product[] actual = shop.getProducts(400);
        Product[] expected = {product2, product1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void containsProduct() {
        boolean condition = shop.containsProduct(product2.getName());
        assertTrue(condition);
    }

    @Test
    void findTheCheapest() {
        Product actual = shop.findTheCheapest();
        assertEquals(product2, actual);
    }

    @Test
    void findPhones() {
        Phone[] actual = shop.findPhones("Samsung");
        Phone[] expected = {(Phone) product4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findToys() {
        Toy[] actual = shop.findToys(4);
        Toy[] expected = {(Toy) product5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findFood() {
        Food[] actual1 = shop.findFood("2023.01.7");
        Food[] expected = {(Food) product1};
        assertArrayEquals(expected, actual1);
        Food[] actual2 = shop.findFood("Sat Jan 7 00:00:00 GMT+04:00 2023");
        assertArrayEquals(expected, actual2);
        Food[] actual3 = shop.findFood(new GregorianCalendar(2023, Calendar.JANUARY, 8).getTime());
        assertArrayEquals(expected, actual3);
    }
}