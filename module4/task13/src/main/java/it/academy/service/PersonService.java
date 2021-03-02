package it.academy.service;

import it.academy.dao.PersonDao;
import it.academy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    public List<Person> findAllPersons() {
        return personDao.findAllPersons();
    }

    @Transactional
    public void savePerson(Person person) {
       personDao.save(person);
    }
}
