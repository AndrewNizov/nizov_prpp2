package lab_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Низов ПРпп2");

        // Абстрактный класс MenuItem хранит общие свойства всех позиций меню.
        // Все его наследники самостоятельно рассчитывают стоимость блюда.
        // Интерфейс TakeawayPackable задаёт способ расчёта стоимости упаковки.
        // И так можно работать с разными объектами через один тип.

        MenuItem[] menu = {
                new HotDish("Стейк", 300, 65),
                new Drink("Морс", 400),
                new Dessert("Чизкейк", 150)
        };

        System.out.println("\nМеню:");
        for (MenuItem item : menu) {
            System.out.println(item.getName() + " — " + item.getPrice() + " руб.");
        }

        Arrays.sort(menu);

        System.out.println("\nМеню после сортировки:");
        for (MenuItem item : menu) {
            System.out.println(item.getName() + " — " + item.getPrice() + " руб.");
        }

        TakeawayPackable[] packableItems = {
                new HotDish("Стейк", 300, 65),
                new Drink("Морс", 400),
                new CutlerySet("Набор", 3)
        };

        double totalPackagingCost = 0;

        System.out.println("\nСтоимость упаковки:");
        for (TakeawayPackable item : packableItems) {
            System.out.println(item.getPackagingInfo());
            totalPackagingCost += item.calculatePackagingCost();
        }

        System.out.println("Общая стоимость упаковки: " + totalPackagingCost + " руб.");
    }
}