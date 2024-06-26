public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // GET /api/courses: Get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // POST /api/courses: Create a new course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // GET /api/courses/{id}: Get a course by id
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

    // PUT /api/courses/{id}: Update a course by id
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course existingCourse = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        return courseRepository.save(existingCourse);
    }

    // DELETE /api/courses/{id}: Delete a course by id
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
}