public class Enrollment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    private String grade;
    // Getters and Setters
}