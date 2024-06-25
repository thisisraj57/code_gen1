public class Main {

    public static void main(String[] args) {
        Person person1 = new Person();

        person1.setName("John Doe");
        person1.setCity("Los Angeles");

        System.out.println("Person Name: " + person1.getName());
        System.out.println("Person City: " + person1.getCity());
    }
}