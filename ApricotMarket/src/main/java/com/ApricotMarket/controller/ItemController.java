package com.ApricotMarket.controller;

import com.ApricotMarket.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    //게시글 업로드 양식 띄우기
    @GetMapping("/item/new")
    public String createItemForm(){
        return "write";
    }


}
