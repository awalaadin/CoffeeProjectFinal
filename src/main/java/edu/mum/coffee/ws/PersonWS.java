/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.ws;


import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author awalaa
 */
@RestController
public class PersonWS {
    @Autowired
    private PersonService personService;
    
    @RequestMapping(value = "/personWS", method=RequestMethod.GET)
    public List<Person> getAll(){
        return personService.getAll();
    }
    @RequestMapping(value = "/personWS/{id}", method=RequestMethod.GET)
    public Person findById(@PathVariable long id){
        return personService.findById(id);
    }
   
    @RequestMapping(value = "/personWS", method=RequestMethod.POST)
    public Person Add(@RequestBody Person person){
        return personService.savePerson(person);
    }
    
    @RequestMapping(value = "/personWS/{id}", method=RequestMethod.PUT)
    public Person update(@PathVariable long id,@RequestBody Person person){
        return personService.savePerson(person);
    }
    
  
    
}
