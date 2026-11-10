package lab_3;

public  abstract class MenuItem implements Comparable<MenuItem> {
    private String name;
    private double quantity;

    public MenuItem(String name, double quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public double getQuantity(){
        return quantity;
    }

    public abstract double calculatePrice();

    public double getPrice(){
        return calculatePrice();
    }

    @Override
    public int compareTo(MenuItem other){
        return Double.compare(this.getPrice(),other.getPrice());
    }
}
