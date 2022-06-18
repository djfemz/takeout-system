package com.takeout.takeout_system.data.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductCatalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private Set<Item> items;
}
