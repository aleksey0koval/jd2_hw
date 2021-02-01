package it.academy.loader;

import it.academy.Dao.Dao;
import it.academy.Dao.PersonDao;
import it.academy.pojos.Address;
import it.academy.pojos.Person;

public class Loader {

    public static void main(String[] args) {

        Dao<Person, Integer> personDao = new PersonDao();
        Person person = new Person(null, 25,"Ivan", "Ivanov"
                , new Address("Minsk", "Lenina", 123456));

        personDao.create(person);

        personDao.read(1);
    }
}
