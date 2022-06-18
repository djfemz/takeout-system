package com.takeout.takeout_system.data.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amountTendered;
    @OneToOne
    private Sale sale;
}
