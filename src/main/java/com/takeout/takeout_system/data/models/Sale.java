package com.takeout.takeout_system.data.models;

import org.hibernate.annotations.Cascade;

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
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private Customer customer;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private Payment payment;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    private Set<OrderLineItem> orderLineItems;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private Store store;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private Delivery delivery;
    private LocalDateTime time;
}
