package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Customer;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/palindrome/{a}")
    private String checkPalindrome(@PathVariable String a){
        return String.format("The word '%s' is %sa palindrome!", a, isPalindrome(a) ? "" : "not ");
    }

    private boolean isPalindrome(String a){
        return new StringBuilder(a).reverse().toString().equalsIgnoreCase(a);

    }
    
    private final List<Customer> customers = new CopyOnWriteArrayList<>(Arrays.asList(
        new Customer(123, "John", "john@test.com", "test 456", "1800785", "test"),
        new Customer(124, "Jane", "jane@test.com", "test 12", "789456123", "test"),
        new Customer(125, "Jack", "jack@test.com", "123", "5691728591", "test")));
        
    //@RequestMapping(method = RequestMethod.GET) // or @GetMapping
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customers);
    }

    //@RequestMapping(value = "/{username}", method=RequestMethod.GET)  // or @GetMapping
    @GetMapping("/{name}")
    public ResponseEntity<?> getCustomer(@PathVariable String name){
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found" +name);
    }
    
    //@RequestMapping(method=RequestMethod.POST)  // or @PostMapping
    @PostMapping
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer){
        customers.add(customer);
        URI url = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{name}")
        .buildAndExpand(customer.getName()).toUri();
        
        return ResponseEntity.created(url).build();
    }

    //@RequestMapping(method=RequestMethod.PUT)  // or @PutMapping
    @PutMapping
    public ResponseEntity<?> putCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setEmail(customer.getEmail());
                c.setAddress(customer.getAddress());
                c.setPhone(customer.getPhone());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //@RequestMapping(method=RequestMethod.PATCH)  // or @PatchMapping
    @PatchMapping
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getEmail() != null) {
                    c.setEmail(customer.getEmail());
                }

                if (customer.getAddress() != null) {
                    c.setAddress(customer.getAddress());
                }

                if (customer.getPhone() != null) {
                    c.setPhone(customer.getPhone());
                }

                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }

                return ResponseEntity.ok().body("Customer: "+customer.getName()+ " was updated successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer: "+customer.getName()+ " not found");
    }

    //@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                return ResponseEntity.noContent().build();
            } 
        }
        return ResponseEntity.notFound().build();
    }
}