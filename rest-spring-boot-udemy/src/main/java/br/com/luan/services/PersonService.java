package br.com.luan.services;

import br.com.luan.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Jon");
        person.setLastName("Snow");
        person.setAddress("Winterfel");
        person.setGender("male");
        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for(int i=0; i<8; i++) {
            Person person = new Person();
            person.setId(i+1);
            person.setLastName("Snow");
            person.setFirstName("Jon");
            person.setGender("male");
            person.setAddress("Winterfel");
            persons.add(person);
        }
        return persons;
    }
}
