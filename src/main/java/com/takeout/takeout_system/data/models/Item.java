package com.takeout.takeout_system.data.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stockNumber;
    private BigDecimal orderPrice;
    @OneToOne
    private Store store;
    @OneToOne
    private ProductCatalogue productCatalogue;
}
