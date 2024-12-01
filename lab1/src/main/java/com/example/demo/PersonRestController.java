package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PersonRestController {
    private PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{firstName}/{lastName}")
    public ResponseEntity<Person> getPerson(@PathVariable String firstName, @PathVariable String lastName) {
        try{
            return ResponseEntity.ok(personService.getPerson(firstName, lastName));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPeople() {
        return ResponseEntity.ok(personService.getPeople());
    }

    @PostMapping("/addPerson/")
    public ResponseEntity<Person> addPeople(@RequestBody Person person) {
        try{
            personService.addPerson(person);
            return ResponseEntity.ok(person);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/person/{firstName}/{lastName}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable String firstName,
            @PathVariable String lastName,
            @RequestBody Person person) {
        try {
            personService.setPerson(firstName, lastName, person);
            return ResponseEntity.ok(person);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/person")
    public ResponseEntity<Person> deletePerson(@RequestBody Person person) {
        try{
            personService.removePerson(person);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
