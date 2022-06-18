package com.takeout.takeout_system.data.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private Boolean isOpened;
    @OneToMany
    private Set<Sale> sales;
    @OneToMany
    private Set<Item> items;
    @OneToMany
    private Set<ProductCatalogue> productCatalogues;
}
