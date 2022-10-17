 package com.microservice.springbootbackend.Models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

 @Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "billing_tracker")
public class Billings {
    @Id // creating the primary key by default
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generating the pks automatically
    private long id;

    @Column(name = "bill_name")
    private String name;

    private String description;

    @Column(name = "bill_amount")
    private BigDecimal amount;

    private String category;


    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date date;
}
