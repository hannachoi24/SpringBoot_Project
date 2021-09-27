package com.ApricotMarket.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Item {
    @Id @GeneratedValue
    private Long id;
    @Column
    private String image;
    @Column
    private String location;
    @Column
    private int price;
    @Column
    private LocalDateTime ExpiryDate;
    @Column
    private Category category;
    @Column
    private int like;
    @Column
    private String Description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
}
