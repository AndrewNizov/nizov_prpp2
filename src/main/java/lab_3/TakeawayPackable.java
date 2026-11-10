package lab_3;

public interface TakeawayPackable {

    double calculatePackagingCost();

    default String getPackagingInfo() {
        return "Стоимость упаковки: "
                + calculatePackagingCost() + " руб.";
    }
}