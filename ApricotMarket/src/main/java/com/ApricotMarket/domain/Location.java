package com.ApricotMarket.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String city;
    @Column
    private String district;
    @Column
    private String town;
    @OneToMany(mappedBy = "location")
    private List<User> users;
    @OneToMany(mappedBy = "location")
    private List<Item> items;
}
