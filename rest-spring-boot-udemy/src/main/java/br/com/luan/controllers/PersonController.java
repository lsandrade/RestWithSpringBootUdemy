package br.com.luan.controllers;

import br.com.luan.data.model.Person;
import br.com.luan.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;


    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public Person findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    public List<Person> findAll(){
        return service.findAll();
    }

    @PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);

        return String.format("Person #%s deleted.", id);
    }
}
