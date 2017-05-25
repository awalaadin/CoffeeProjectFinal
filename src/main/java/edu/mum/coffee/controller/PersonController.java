package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sherxon on 5/23/17.
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

  @Autowired
  PersonService personService;

  @GetMapping("")
  public List<Person> homePage() {
    return personService.getAll();
  }

  @PostMapping("")
  public Person create(Person person) {
    personService.savePerson(person);
    return person;
  }

  @DeleteMapping("/{id}")
  public Person delete(@PathVariable Integer id) {
    Person person=personService.find(id);
    personService.delete(person);
    return person;
  }

  @PutMapping("")
  public Person put(Person person) {
    personService.save(person);
    return person;
  }

}
