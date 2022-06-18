package com.takeout.takeout_system.data.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean isComplete;
    private BigDecimal amount;
    private Boolean isReadyToPay;
    private Boolean isAccept;
    @OneToOne
    private Customer customer;
    @OneToOne
    private Payment payment;
    @OneToMany
    private Set<OrderLineItem> orderLineItems;
    @OneToOne
    private Delivery delivery;
    private LocalDateTime time;
}
