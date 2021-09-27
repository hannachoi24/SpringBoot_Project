package com.ApricotMarket.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue
    private Long id;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String location;
    @Column
    private Role role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();
}
