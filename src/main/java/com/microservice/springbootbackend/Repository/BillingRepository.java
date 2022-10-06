package com.microservice.springbootbackend.Repository;

import com.microservice.springbootbackend.Models.Billings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billings, Long> {
    // Jpa repository enables us perform crud database operations

}
