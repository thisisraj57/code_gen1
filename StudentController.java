public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET /api/students: Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // POST /api/students: Create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // GET /api/students/{id}: Get a student by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    // PUT /api/students/{id}: Update a student by id
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        return studentRepository.save(existingStudent);
    }

    // DELETE /api/students/{id}: Delete a student by id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}