package com.takeout.takeout_system.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(insertable = false, nullable = false)
    private Long id;
    private String name;
    private String attribute3;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Sale> sale;
}
