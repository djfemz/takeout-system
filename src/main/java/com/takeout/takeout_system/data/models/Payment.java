package com.takeout.takeout_system.data.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amountTendered;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private Sale sale;
}
