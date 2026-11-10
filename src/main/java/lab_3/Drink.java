package lab_3;

public class Drink extends MenuItem implements TakeawayPackable {

    public Drink(String name, double volume) {
        super(name, volume);
    }

    @Override
    public double calculatePrice() {
        return getQuantity() * 0.25;
    }

    @Override
    public double calculatePackagingCost() {
        return 25;
    }
}