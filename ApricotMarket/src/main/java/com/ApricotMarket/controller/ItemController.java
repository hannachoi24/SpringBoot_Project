package com.ApricotMarket.controller;

import com.ApricotMarket.service.ItemService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@NoArgsConstructor
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    //게시글 업로드 양식 띄우기
    @GetMapping("/item/new")
    public String createItemForm(){
        return "write";
    }


}
