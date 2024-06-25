public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Timestamp orderDate;
    private BigDecimal totalAmount;

    // Getters and setters
}