public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long customerId;
    private Integer rating;
    private String reviewText;

    // Getters and setters
}