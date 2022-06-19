package com.takeout.takeout_system.data.models;

import org.hibernate.annotations.Cascade;

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
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    private Set<Sale> sales;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    private Set<Item> items;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    private Set<ProductCatalogue> productCatalogues;
}
