package com.microservice.springbootbackend.Repository;

import com.microservice.springbootbackend.Models.Billings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billings, Long> {
    List<Billings> findByName(String name);
//    List<Billings> findByTitle(String title);
    List<Billings> findByCategory(String category);

    List<Billings> findByDateBetween(Date startDate, Date endDate);

}
