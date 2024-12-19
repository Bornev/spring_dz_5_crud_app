package gb.example.crud_app.controller;

import gb.example.crud_app.model.Person;
import gb.example.crud_app.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}