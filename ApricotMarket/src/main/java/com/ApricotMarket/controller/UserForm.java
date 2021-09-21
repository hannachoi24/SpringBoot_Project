package com.ApricotMarket.controller;

import com.ApricotMarket.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    private String email;
    private String password;
    private String location;
    private Role role;
}
