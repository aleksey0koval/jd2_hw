package it.academy.loader;

import it.academy.Dao.AddressDao;
import it.academy.Dao.Dao;
import it.academy.Dao.PersonDao;
import it.academy.pojos.Address;
import it.academy.pojos.Person;

public class Loader {

    public static void main(String[] args) {
        Dao<Address, Integer> addressDao = new AddressDao();
        Address address = new Address();

        address.setId(null);
        address.setCity("Hrodno");
        address.setStreet("ul.Ozheshko");
        address.setPostalCode(123456);

        System.out.println(address);

        addressDao.create(address);

        Dao<Person, Integer> personDao = new PersonDao();
        Person person = new Person();

        person.setId(null);
        person.setName("Ivan");
        person.setSurname("Ivanov");
        person.setAge(25);

        System.out.println(person);

        personDao.create(person);

        addressDao.read(1);
        personDao.read(1);
    }
}
