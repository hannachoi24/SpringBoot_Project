package com.ApricotMarket.controller;

import com.ApricotMarket.model.User;
import com.ApricotMarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String getLogin() {
        return "/signin";
    }


    @GetMapping("/signup")
    public String getSignUp() {
        return "/signup";
    }

    @PostMapping("/signup")
    public String postSignUp(User user) {
        /**
         * 사용자 저장을 해야하는데 사용자를 저장할 때
         * 패스워드 암호화도 필요하고 사용자 권한도 추가해줘야 한다
         * 이러한 비즈니스 로직이 들어가기 때문에 Service 클래스에서 처리해준다.
         */
        userService.save(user);
        return "redirect:/";
    }
}