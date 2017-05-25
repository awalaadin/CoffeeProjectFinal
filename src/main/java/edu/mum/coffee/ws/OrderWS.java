/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.ws;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.repository.OrderRepository;
import edu.mum.coffee.service.OrderService;
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
public class OrderWS {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/orderWS")
    public List<Order> getAll(){
        return orderService.findAll();
    }
     
    @RequestMapping(value = "/orderWS/{id}", method=RequestMethod.GET)
    public Order findById(@PathVariable int id){
        return orderService.findById(id);
    }
   
    @RequestMapping(value = "/orderWS", method=RequestMethod.POST)
    public Order Add(@RequestBody Order order){
        return orderService.save(order);
    }
    
//    @RequestMapping(value = "/orderWS/{id}", method=RequestMethod.PUT)
//    public Order update(@PathVariable long id,@RequestBody Order order){
//        return orderService.save(order);
//    }
    
}
