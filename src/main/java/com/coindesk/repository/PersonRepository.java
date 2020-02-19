package com.coindesk.repository;

import java.util.List;

import com.coindesk.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findById(long id);

    List<Person> findAll();
    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);

    @Override
    void delete(Person entity);
}