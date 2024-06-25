public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private double price;
    private int numBedrooms;
    private int numBathrooms;
    private String type; // e.g., house, condo, apartment

    // Getters and setters omitted for brevity
}