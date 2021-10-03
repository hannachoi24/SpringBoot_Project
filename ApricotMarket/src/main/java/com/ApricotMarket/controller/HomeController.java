package com.ApricotMarket.controller;

import com.ApricotMarket.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    private final ItemService itemService;
    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("itemlist",itemService.recentItems());
        return "home";
    }

    @GetMapping("/introduce")
    public String introduce(){
        return "introduce";
    }

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("itemlist",itemService.recentItems());
        return "home";
    }
}
