package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sherxon on 5/23/17.
 */
@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/list")
  public List<Product> homePage() {
    return productService.findAll();
  }

  @GetMapping("/add")
  @PreAuthorize(value = "hasRole('ADMIN')")
  public ModelAndView add() {
    ModelAndView modelAndView= new ModelAndView("add");
    return modelAndView;
  }

  @PostMapping("/add")
  @PreAuthorize(value = "hasRole('ADMIN')")
  public ModelAndView crea(Product product) {
    ModelAndView modelAndView= new ModelAndView("add");
    productService.save(product);
    modelAndView.addObject("successMessage", "Product has been saved successfully");
    return modelAndView;
  }

  @PostMapping("")
  @PreAuthorize(value = "hasRole('ADMIN')")
  public Product create(Product product) {
    productService.save(product);
    return product;
  }

  @DeleteMapping("/{id}")
  @PreAuthorize(value = "hasAuthority('ADMIN')")
  public Product create(@PathVariable Integer id) {
    Product product=productService.find(id);
    productService.delete(product);
    return product;
  }

  @PutMapping("")
  @PreAuthorize(value = "hasAuthority('ADMIN')")
  public Product put(Product product) {
    productService.save(product);
    return product;
  }

}
