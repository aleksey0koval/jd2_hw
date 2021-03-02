package it.academy.web.controller;

import it.academy.model.Person;
import it.academy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String allPerson(Model model) {
        List<Person> personList = personService.findAllPersons();
        if (personList.isEmpty()) {
            return "listnull";
        } else {
            model.addAttribute("personList", personService.findAllPersons());
            return "index";
        }
    }

    @GetMapping("/add-person")
    public String addPerson() {
        return "add-person";
    }

    @PostMapping("/add-person/add")
    public String addProduct(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "redirect:/";
    }
}
