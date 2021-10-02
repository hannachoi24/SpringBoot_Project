package com.ApricotMarket.controller;

import com.ApricotMarket.domain.User;
import com.ApricotMarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
 
    private final UserService userService;

    @GetMapping("/signin")
    public String getLogin() {
        System.out.println("controller: signinform");
        return "/signin";
    }

    @GetMapping("/signup")
    public String getSignUp() {
        System.out.println("controller: signupform");
        return "/signup";
    }

    @PostMapping("/signup")
    public String postSignUp(UserForm form, Model model) {
        System.out.println("form.getEmail() "+ form.getEmail());
        System.out.println("form.getpassword "+ form.getPassword());
//        User user = new User();
        model.addAttribute("UserForm",new UserForm());
//        .setEmail(form.getEmail());
//        user.setPassword(form.getPassword());
//        user.setRole(form.getRole());

        userService.save(form);

        return "redirect:/";
    }


    public UserController(UserService userService) {
        this.userService = userService;
    }
}




