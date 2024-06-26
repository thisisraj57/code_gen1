public class ProfessorController {

    private final ProfessorRepository professorRepository;

    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    // GET /api/professors: Get all professors
    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    // POST /api/professors: Create a new professor
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    // GET /api/professors/{id}: Get a professor by id
    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor not found with id: " + id));
    }

    // PUT /api/professors/{id}: Update a professor by id
    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        Professor existingProfessor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor not found with id: " + id));
        existingProfessor.setName(professor.getName());
        existingProfessor.setDepartment(professor.getDepartment());
        return professorRepository.save(existingProfessor);
    }

    // DELETE /api/professors/{id}: Delete a professor by id
    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }
}