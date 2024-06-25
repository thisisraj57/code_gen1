public class PropertyController {
    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));
    }

    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable Long id, @RequestBody Property propertyDetails) {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));
        property.setAddress(propertyDetails.getAddress());
        property.setCity(propertyDetails.getCity());
        property.setState(propertyDetails.getState());
        property.setZipCode(propertyDetails.getZipCode());
        property.setPrice(propertyDetails.getPrice());
        property.setNumBedrooms(propertyDetails.getNumBedrooms());
        property.setNumBathrooms(propertyDetails.getNumBathrooms());
        property.setType(propertyDetails.getType());
        return propertyRepository.save(property);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyRepository.deleteById(id);
    }
}