package br.com.luan.services;

import br.com.luan.model.Person;
import org.springframework.stereotype.Service;

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

}
