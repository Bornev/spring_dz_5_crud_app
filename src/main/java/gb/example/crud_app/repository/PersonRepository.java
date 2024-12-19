package gb.example.crud_app.repository;

import gb.example.crud_app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}