package lab_4;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductsCount() {
        List<Product> products = Main.createProducts();

        assertEquals(10, products.size());
    }

    @Test
    void testUniqueProductsCount() {
        List<Product> products = Main.createProducts();

        Set<Product> unique = new LinkedHashSet<>(products);

        assertEquals(8, unique.size());
    }

    @Test
    void testEquals() {
        Product first = new Product("Периферия", "Logitech", "Мышь M330", 1890);
        Product second = new Product("Другая категория", "Logitech", "Мышь M330", 2000);

        assertEquals(first, second);
    }

    @Test
    void testNotEquals() {
        Product first = new Product("Периферия", "Logitech", "Мышь M330", 1890);
        Product second = new Product("Периферия", "Samsung", "Мышь M330", 1890);

        assertNotEquals(first, second);
    }

    @Test
    void testHashCode() {
        Product first = new Product("Периферия", "Logitech", "Мышь M330", 1890);
        Product second = new Product("Другая категория", "Logitech", "Мышь M330", 2000);

        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void testPriceSorting() {
        List<Product> products = new ArrayList<>(new LinkedHashSet<>(Main.createProducts()));

        products.sort(
                Comparator.comparingInt(Product::getPrice)
                        .thenComparing(Product::getSupplier)
                        .thenComparing(Product::getName)
        );

        assertEquals("Кабель USB-C 1 м", products.get(0).getName());
        assertEquals("Монитор 27QN880", products.get(7).getName());
    }

    @Test
    void testMinAndMaxPrice() {
        List<Product> products = new ArrayList<>(new LinkedHashSet<>(Main.createProducts()));

        Product min = Collections.min(products, Comparator.comparingInt(Product::getPrice));
        Product max = Collections.max(products, Comparator.comparingInt(Product::getPrice));

        assertEquals(490, min.getPrice());
        assertEquals(24900, max.getPrice());
    }

    @Test
    void testRemoveIf() {
        List<Product> products = new ArrayList<>(new LinkedHashSet<>(Main.createProducts()));

        products.removeIf(product -> product.getPrice() < 1000);

        assertEquals(6, products.size());
    }

    @Test
    void testLogitechFrequency() {
        List<Product> products = new ArrayList<>(new LinkedHashSet<>(Main.createProducts()));
        List<String> suppliers = new ArrayList<>();

        for (Product product : products) {
            suppliers.add(product.getSupplier());
        }

        assertEquals(2, Collections.frequency(suppliers, "Logitech"));
    }

    @Test
    void testUnmodifiableList() {
        List<Product> products = new ArrayList<>(Main.createProducts());
        List<Product> protectedList = Collections.unmodifiableList(products);

        assertThrows(UnsupportedOperationException.class,
                () -> protectedList.add(
                        new Product("Кабели", "Ugreen", "Кабель HDMI", 500)
                ));
    }
}