public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("Dell XPS", "Dell", 1000);
        computer.printDetails();

        Laptop laptop = new Laptop("MacBook Air", "Apple", 1200, 10);
        laptop.printDetails();
    }
}