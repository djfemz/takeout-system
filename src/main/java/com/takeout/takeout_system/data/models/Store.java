package com.takeout.takeout_system.data.models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String address;
    private boolean isOpened;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Sale> sales;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Item> items;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER)
    private Set<ProductCatalogue> productCatalogues;

    @Override
    public String toString(){
        return id+ " " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (!(obj instanceof Store)) return false;
        return Objects.equals(this.id, ((Store) obj).getId()) && this.name.equals((((Store) obj).name));
    }
}
