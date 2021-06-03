package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return this.repository.save(customer);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getCustomers")
    public Iterable<Customer> getCustomers(){
        return this.repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/findByLastName/{lastName}")
    public Iterable<Customer> getByLastName(@PathVariable String lastName){
        return this.repository.findByLastName(lastName);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete")
    public void delete(@RequestBody Customer customer){
        this.repository.delete(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/id/{id}")
    public void putUpdate(@RequestBody Customer customer,@PathVariable Long id){
        Customer customer1 = this.repository.findById(id).get();
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        this.repository.save(customer1);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update/id/{id}")
    public void patchUpdate(@RequestBody Customer customer,@PathVariable Long id){
        Customer customer1 = this.repository.findById(id).get();
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        this.repository.save(customer1);
    }

}
