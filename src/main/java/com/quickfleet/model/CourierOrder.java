package com.quickfleet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private User courier;

    @ManyToOne
    private Address pickupAddress;
    @ManyToOne
    private Address deliveryAddress;

    private BigDecimal weight;
    private BigDecimal price;

    private String status;

    private LocalDateTime createdAt=LocalDateTime.now();
}
