package com.takeout.takeout_system.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String attribute3;
    @OneToMany
    private List<Sale> sale;
}
