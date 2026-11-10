package lab_4;

import java.util.Objects;

public class Product {

    private String category;
    private String supplier;
    private String name;
    private int price;

    public Product(String category, String supplier, String name, int price) {
        this.category = category;
        this.supplier = supplier;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Product product = (Product) obj;

        return Objects.equals(supplier, product.supplier)
                && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplier, name);
    }

    @Override
    public String toString() {
        return category + " | " + supplier + " | " + name + " | " + price;
    }
}