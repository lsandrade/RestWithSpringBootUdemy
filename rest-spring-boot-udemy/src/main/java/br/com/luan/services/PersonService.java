package br.com.luan.services;

import br.com.exceptions.ResourceNotFoundException;
import br.com.luan.data.model.Person;
import br.com.luan.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonRepository repository;

    public Person findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found fot this id."));
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person update(Person personUpdated) {
        Person entity = findById(personUpdated.getId());
        entity.setFirstName(personUpdated.getFirstName());
        entity.setLastName(personUpdated.getLastName());
        entity.setAddress(personUpdated.getAddress());
        entity.setGender(personUpdated.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {
        Person entity = findById(id);
        repository.delete(entity);
    }
}
