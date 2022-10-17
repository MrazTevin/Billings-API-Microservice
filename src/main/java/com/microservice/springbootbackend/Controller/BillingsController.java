package com.microservice.springbootbackend.Controller;

import com.microservice.springbootbackend.Models.Exception.ResourceNotFound;
import com.microservice.springbootbackend.Models.Billings;
import com.microservice.springbootbackend.Repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Optional;

@RestController
@RequestMapping("/api/v1/billings")
public class BillingsController {
    @Autowired
    private BillingRepository billingRepository;

//    @GetMapping
//    public List<Billings> getAllBillings() {
//        return billingRepository.findAll();
//    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllBillings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
       try {
           List<Billings> billings = new ArrayList<Billings>();
           Pageable paging = PageRequest.of(page,size);

           Page<Billings> pageResults;
           pageResults = billingRepository.findAll(paging);

           billings = pageResults.getContent();

           Map<String, Object> response = new HashMap<>();
           response.put("billings", billings);
           response.put("currentPage", pageResults.getNumber());
           response.put("totalItems", pageResults.getTotalElements());
           response.put("totalPages", pageResults.getTotalPages());

           return new ResponseEntity<>(response, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }
    // create billings REST api
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Billings addNewBillings(@RequestBody  Billings billings) {
        return billingRepository.save(billings);
    }

    // get billing by id REST API

    @GetMapping("{id}")
    public ResponseEntity<Billings> getBillingById(@PathVariable long id) {
        Billings billings = billingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Billings not found with id: " + id));

        return ResponseEntity.ok(billings);
    }
    // update the billings
    @PutMapping("{id}")
    public ResponseEntity<Billings> updateBillings(@PathVariable long id,@RequestBody Billings userBillings) {
        Billings updateBillings = billingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Billings not found with id: " + id));


        updateBillings.setName(userBillings.getName() != null? userBillings.getName() : updateBillings.getName());
        updateBillings.setAmount(userBillings.getAmount() !=null? userBillings.getAmount() : updateBillings.getAmount());
        updateBillings.setCategory(userBillings.getCategory() !=null? userBillings.getCategory() : updateBillings.getCategory());
        updateBillings.setDescription(userBillings.getDescription() !=null? userBillings.getDescription() : updateBillings.getDescription());
        updateBillings.setDate(userBillings.getDate() !=null? userBillings.getDate() : updateBillings.getDate());
        billingRepository.save(updateBillings);

        return ResponseEntity.ok(updateBillings);
    }

    // delete the billings

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBilling(@PathVariable long id) {
        Billings billings = billingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Employee not exist with id: " + id));

        billingRepository.delete(billings);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Billings>> searchAllBills(@RequestParam(required = false) String name) {
        try {
            List<Billings> billings = new ArrayList<Billings>();
            if (name == null)
                billingRepository.findAll().forEach(billings::add);
            else
                billingRepository.findByName(name).forEach(billings::add);
            if (billings.isEmpty())  {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(billings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
