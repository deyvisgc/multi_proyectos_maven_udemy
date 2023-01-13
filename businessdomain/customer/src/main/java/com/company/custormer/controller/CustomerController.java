package com.company.custormer.controller;

import com.company.custormer.entities.CustomerEntity;
import com.company.custormer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController{
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("/")
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity save = customerRepository.save(customerEntity);
        return ResponseEntity.ok(save);
    }
}
