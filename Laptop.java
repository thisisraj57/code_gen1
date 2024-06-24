public class Laptop extends Computer {
    private int batteryLife;

    public Laptop(String name, String brand, int price, int batteryLife) {
        super(name, brand, price);
        this.batteryLife = batteryLife;
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Battery Life: " + batteryLife);
    }
}