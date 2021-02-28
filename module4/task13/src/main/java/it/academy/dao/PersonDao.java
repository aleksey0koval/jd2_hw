package it.academy.dao;

import it.academy.model.Person;

import java.util.List;

public interface PersonDao {

    List<Person> findAllPersons();

    void save(Person person);
}
