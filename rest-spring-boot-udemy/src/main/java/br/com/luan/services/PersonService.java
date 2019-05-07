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
        return mockPerson(counter.incrementAndGet());
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for(int i=0; i<8; i++) {
            Person person = mockPerson((long) i+1);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(Long id) {
        Person person = new Person();
        person.setId(id);
        person.setLastName("Snow");
        person.setFirstName("Jon");
        person.setGender("male");
        person.setAddress("Winterfel");
        return person;
    }

    public Person create(Person person) {
        person.setId(counter.incrementAndGet());
        return person;
    }
}
