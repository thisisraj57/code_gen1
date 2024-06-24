public class Computer {
    private String name;
    private String brand;
    private int price;

    public Computer(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public void printDetails() {
        System.out.println("Computer Details:");
        System.out.println("Name: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }
}