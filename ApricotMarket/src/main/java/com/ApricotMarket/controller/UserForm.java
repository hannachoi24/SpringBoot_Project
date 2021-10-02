package com.ApricotMarket.controller;

import com.ApricotMarket.domain.Role1;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    private String email;
    private String password;
    private String city;
    private String district;
    private String town;
    private Role1 role1;
}
