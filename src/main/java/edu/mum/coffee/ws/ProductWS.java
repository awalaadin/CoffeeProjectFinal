/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.ws;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
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
public class ProductWS {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/productWS")
    public List<Product> getAll(){
        return productService.getAllProduct();
    }
    
    @RequestMapping(value = "/productWS/{id}", method=RequestMethod.GET)
    public Product findById(@PathVariable int id){
        return productService.getProduct(id);
    }
    
    @RequestMapping(value = "/productWS", method=RequestMethod.POST)
    public Product Add(@RequestBody Product product){
        return productService.save(product);
    }
    
    @RequestMapping(value = "/productWS/{id}", method=RequestMethod.PUT)
    public Product update(@PathVariable int id,@RequestBody Product product){
        return productService.save(product);
    }
    
    @RequestMapping(value = "/productWS/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        Product product = productService.getProduct(id);
        if(product != null)
            productService.delete(product);
    }
       
}
