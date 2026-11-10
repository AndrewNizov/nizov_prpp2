package lab_3;

public class CutlerySet implements TakeawayPackable {

    private String name;
    private int utensilCount;

    public CutlerySet(String name, int utensilCount) {
        this.name = name;
        this.utensilCount = utensilCount;
    }

    public String getName() {
        return name;
    }

    public int getUtensilCount() {
        return utensilCount;
    }

    @Override
    public double calculatePackagingCost() {
        return utensilCount * 15;
    }

    @Override
    public String getPackagingInfo() {
        return "Упаковка набора приборов: " + calculatePackagingCost() + " руб.";
    }
}