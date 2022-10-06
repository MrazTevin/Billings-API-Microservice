package com.microservice.springbootbackend.Controller;

import com.microservice.springbootbackend.Models.Billings;
import com.microservice.springbootbackend.Repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/billings")
public class BillingsController {
    @Autowired
    private BillingRepository billingRepository;

    @GetMapping
    public List<Billings> getAllBillings() {
        return billingRepository.findAll();
    }

//    // create employee REST api
//    public List<Billings> addNewBillings() {
//
//    }
}
