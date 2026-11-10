package lab_4;

import java.util.*;
public class Main {

    public static List<Product> createProducts() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Периферия", "Logitech", "Мышь M330", 1890));
        products.add(new Product("Накопители", "Samsung", "SSD 980 500GB", 4590));
        products.add(new Product("Периферия", "Logitech", "Клавиатура K380", 1890));
        products.add(new Product("Кабели", "Ugreen", "Кабель USB-C 1 м", 490));
        products.add(new Product("Накопители", "Samsung", "SSD 980 500GB", 4590));
        products.add(new Product("Мониторы", "LG", "Монитор 24MP60", 11900));
        products.add(new Product("Кабели", "Ugreen", "Хаб USB 4 порта", 1890));
        products.add(new Product("Периферия", "Logitech", "Мышь M330", 1890));
        products.add(new Product("Накопители", "Kingston", "Флешка DT50 64GB", 790));
        products.add(new Product("Мониторы", "LG", "Монитор 27QN880", 24900));
        return products;
    }

    public static void main(String[] args) {
        System.out.println("Nizov Andrey, prpp2");

        List<Product> products = createProducts();
        Set<Product> uniqueProducts = new LinkedHashSet<>(products);
        System.out.println("1) Строк в накладной: " + products.size());
        System.out.println("2) Уникальных позиций: " + uniqueProducts.size()
                + "; повторов отброшено: "
                + (products.size() - uniqueProducts.size()));


        Map<String, List<Product>> categories = new TreeMap<>();
        for (Product product : uniqueProducts) {
            categories.computeIfAbsent(product.getCategory(), key -> new ArrayList<>())
                    .add(product);
        }

        System.out.println("3) Категорий: " + categories.size());

        for (Map.Entry<String, List<Product>> entry : categories.entrySet()) {
            System.out.println("   " + entry.getKey() + " (" + entry.getValue().size() + "): "
                    + String.join(", ",
                    entry.getValue().stream().map(Product::getName).toList()));
        }


        List<Product> priceList = new ArrayList<>(uniqueProducts);
        priceList.sort(
                Comparator.comparingInt(Product::getPrice)
                        .thenComparing(Product::getSupplier)
                        .thenComparing(Product::getName)
        );

        System.out.println("4) Прайс-лист:");

        for (Product product : priceList) {
            System.out.println("   " + product.getPrice() + "  "
                    + product.getSupplier() + " — " + product.getName());
        }

        Product cheapest = Collections.min(
                uniqueProducts,
                Comparator.comparingInt(Product::getPrice)
        );
        Product mostExpensive = Collections.max(
                uniqueProducts,
                Comparator.comparingInt(Product::getPrice)
        );

        System.out.println("5) Самая дешёвая: "
                + cheapest.getSupplier() + " — "
                + cheapest.getName() + " ("
                + cheapest.getPrice() + ")");

        System.out.println("   Самая дорогая: "
                + mostExpensive.getSupplier() + " — "
                + mostExpensive.getName() + " ("
                + mostExpensive.getPrice() + ")");

        List<String> suppliers = new ArrayList<>();


        for (Product product : uniqueProducts) {
            suppliers.add(product.getSupplier());
        }
        int logitechCount = Collections.frequency(suppliers, "Logitech");

        System.out.println("6) Позиций Logitech: " + logitechCount);

        List<Product> protectedList = Collections.unmodifiableList(priceList);

        try {
            protectedList.add(new Product("Кабели", "Ugreen", "Кабель HDMI", 500));
        } catch (UnsupportedOperationException e) {
            System.out.println("7) Попытка добавить в защищённый список: "
                    + e.getClass().getSimpleName());
        }

        int beforeRemoval = uniqueProducts.size();
        uniqueProducts.removeIf(product -> product.getPrice() < 1000);

        int removedCount = beforeRemoval - uniqueProducts.size();

        System.out.println("8) Дешевле 1000 руб. — убрано: "
                + removedCount + "; осталось: " + uniqueProducts.size());

        Map<String, Integer> supplierCounts = new TreeMap<>();
        for (Product product : uniqueProducts) {
            supplierCounts.merge(product.getSupplier(), 1, Integer::sum);
        }
        System.out.println("9) Осталось по поставщикам: " + supplierCounts);
    }


}