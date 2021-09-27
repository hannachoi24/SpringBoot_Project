package com.ApricotMarket.controller;

import com.ApricotMarket.model.Role;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class UserForm {
    private String email;
    private String password;
    private String location;
    private Role role;
}
