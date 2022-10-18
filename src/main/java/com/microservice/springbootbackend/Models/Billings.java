 package com.microservice.springbootbackend.Models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @NotBlank(message = "Billing name must not be null")
    private String name;

    private String description;

    @Column(name = "bill_amount")
    @NotNull(message = "Billing amount should not be null")
    private BigDecimal amount;

    @NotBlank(message = "Category should not be null")
    private String category;


    @CreatedDate
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date must not be null")
    private Date date;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
