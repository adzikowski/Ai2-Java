package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/people")
    public String getAllPeople(Model model) {
        model.addAttribute("people", personService.getPeople());
        return "people";
    }

    @GetMapping("/people/edit")
    public String showEditForm(
            @ModelAttribute("person") Person person,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String familyName,
            Model model) {
        if (firstName != null && familyName != null) {
            Person existingPerson = personService.getPerson(firstName, familyName);
            if (existingPerson != null) {
                model.addAttribute("person", existingPerson);
            }
        }
        return "edit-person";
    }

    @PostMapping("/people/edit")
    public String handleEditForm(
            @ModelAttribute Person person,
            @RequestParam String originalFirstName,
            @RequestParam String originalFamilyName,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-person";
        }
        Person existingPerson = personService.getPerson(originalFirstName, originalFamilyName);
        if (existingPerson != null) {
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setFamilyName(person.getFamilyName());
        } else {
            personService.addPerson(person);
        }
        return "redirect:/people";
    }

}
