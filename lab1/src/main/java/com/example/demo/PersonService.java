package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Service
//@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonService {
    private List<Person> People;

    @PostConstruct
    public void init() {
        People = new ArrayList<Person>();
    }
    public List<Person> getPeople() {
        return People;
    }

    public Person getPerson(String firstName, String familyName) {
        return People.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(firstName)
                        && person.getFamilyName().equalsIgnoreCase(familyName))
                .findFirst()
                .orElse(null);
    }
    public void setPerson(String firstName, String familyName, Person updatedPerson) {
        Person person = getPerson(firstName, familyName);
        if (person != null) {
            person.setFirstName(updatedPerson.getFirstName());
            person.setFamilyName(updatedPerson.getFamilyName());
        }
    }
    public void addPerson(Person person) {
        People.add(person);
    }
    public void removePerson(Person person) {
        People.remove(person);
    }
}
