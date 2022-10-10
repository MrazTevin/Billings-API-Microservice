package com.microservice.springbootbackend.Repository;

import com.microservice.springbootbackend.Models.Billings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billings, Long> {
    List<Billings> findByName(String name);
//    List<Billings> findByTitle(String title);
}
