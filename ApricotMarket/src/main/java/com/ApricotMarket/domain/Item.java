package com.ApricotMarket.domain;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String pdn;
    @Column
    private String image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;
    @Column
    private int price;
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column
    private int likes;
    @Column(length = 100)
    private String Description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private Boolean reserved;
}
