package com.takeout.takeout_system.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stockNumber;
    private BigDecimal orderPrice;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private Store store;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private ProductCatalogue productCatalogue;
}
