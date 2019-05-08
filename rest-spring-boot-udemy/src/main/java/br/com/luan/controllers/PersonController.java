package br.com.luan.controllers;

import br.com.luan.model.Person;
import br.com.luan.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;


    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);

        return String.format("Person #%s deleted.", id);
    }
}
