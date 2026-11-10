package lab_3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    void testHotDishPrice() {
        HotDish steak = new HotDish("Стейк", 300, 65);
        assertEquals(530, steak.getPrice());
    }

    @Test
    void testDrinkPrice() {
        Drink drink = new Drink("Морс", 400);
        assertEquals(100, drink.getPrice());
    }

    @Test
    void testDessertPrice() {
        Dessert dessert = new Dessert("Чизкейк", 150);
        assertEquals(375, dessert.getPrice());
    }

    @Test
    void testHotDishPackaging() {
        HotDish steak = new HotDish("Стейк", 300, 65);
        assertEquals(115, steak.calculatePackagingCost());
    }

    @Test
    void testDrinkPackaging() {
        Drink drink = new Drink("Морс", 400);
        assertEquals(25, drink.calculatePackagingCost());
    }

    @Test
    void testCutleryPackaging() {
        CutlerySet set = new CutlerySet("Набор", 3);
        assertEquals(45, set.calculatePackagingCost());
    }

    @Test
    void testHotDishTemperature() {
        HotDish steak = new HotDish("Стейк", 300, 65);
        assertEquals(65, steak.getTemperature());
    }

    @Test
    void testMenuSorting() {
        MenuItem[] menu = {
                new HotDish("Стейк", 300, 65),
                new Drink("Морс", 400),
                new Dessert("Чизкейк", 150)
        };

        Arrays.sort(menu);

        assertEquals("Морс", menu[0].getName());
        assertEquals("Чизкейк", menu[1].getName());
        assertEquals("Стейк", menu[2].getName());
    }
}