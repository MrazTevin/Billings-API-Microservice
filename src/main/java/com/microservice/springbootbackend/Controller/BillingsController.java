package com.microservice.springbootbackend.Controller;

import com.microservice.springbootbackend.Exception.ResourceNotFound;
import com.microservice.springbootbackend.Models.Billings;
import com.microservice.springbootbackend.Repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/api/v1/billings")
public class BillingsController {
    @Autowired
    private BillingRepository billingRepository;

    @GetMapping
    public List<Billings> getAllBillings() {
        return billingRepository.findAll();
    }

    // create billings REST api
    @PostMapping
    public Billings addNewBillings(@RequestBody  Billings billings) {
        return billingRepository.save(billings);
    }

    // get billing by id REST API

//    @GetMapping("{id}")
//    public ResponseEntity<Billings> getBillingById(long id) {
//        return billingRepository;
//    }


}
