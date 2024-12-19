package gb.example.crud_app.service;

import gb.example.crud_app.exception.PersonNotFoundException;
import gb.example.crud_app.model.Person;
import gb.example.crud_app.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with ID: " + id));
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person person = getPersonById(id);
        person.setName(personDetails.getName());
        person.setAge(personDetails.getAge());
        person.setEmail(personDetails.getEmail());
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            throw new PersonNotFoundException("Person not found with ID: " + id);
        }
        personRepository.deleteById(id);
    }
}
