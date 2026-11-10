package lab_3;

public class HotDish extends MenuItem implements TakeawayPackable {

    private int temperature;

    public HotDish(String name, double weight, int temperature) {
        super(name, weight);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public double calculatePrice() {
        return getQuantity() * 1.5 + 80;
    }

    @Override
    public double calculatePackagingCost() {
        return 40 + getQuantity() * 0.25;
    }
}