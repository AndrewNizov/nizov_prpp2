package lab_3;

public class Dessert extends MenuItem {

    public Dessert(String name, double weight) {
        super(name, weight);
    }

    @Override
    public double calculatePrice() {
        return getQuantity() * 2.5;
    }
}