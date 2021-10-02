package com.ApricotMarket.controller;

import com.ApricotMarket.domain.Item;
import com.ApricotMarket.dto.ReservedItemDTO;
import com.ApricotMarket.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
;
import java.util.List;

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
    //게시글 업로드 로직
    @PostMapping("/item/new")
    public String createItem(createItemForm form){
        itemService.createItem(form);
        return "redirect:/";
    }
    //동네별로 게시글검색(메인화면에 띄워지는 게시글)
    @PostMapping("/item/location")
    public String searchByLocation(getAllItemForm form, Model model){
        List<Item> items = itemService.searchByLocation(form.getCity(),form.getDistrict(),form.getTown());
        items.forEach(item -> {
            model.addAttribute("item",item);
        });
        return "지도API페이지";
    }
    //품목명으로검색기능
    @RequestMapping("/item/pdn")
    public String searchByItem(@RequestParam("item") String name, Model model){
        System.out.println(name);
        List<Item> items = itemService.searchByItem(name);
//        items.forEach(item1-> {
//            model.addAttribute("item", item1);
//        });
        model.addAttribute("itemlist", itemService.searchByItem(name));
        System.out.println(itemService.searchByItem(name));
        return "/search";
    }
    //식재료 게시글 가져오기
    @GetMapping("/item/ingredient")
    public String ingredients(Model model){
        List<Item> items = itemService.ingredients();
//        items.forEach(item -> {
////            System.out.println("item.getDescription() : "+ item.getDescription());
////            System.out.println("item.getCategory() : "+ item.getCategory());
//            model.addAttribute("itemlist", item);
//        });
        model.addAttribute("itemlist",itemService.ingredients());
        return "/list-ingredient";
    }
    //완제품 게시글 가져오기
    @GetMapping("/item/cooked")
    public String cookedItems(Model model){
//        List<Item> items = itemService.cookedItems();
//        items.forEach(item -> {
//            model.addAttribute("item", item);
//        });
        model.addAttribute("itemlist",itemService.cookedItems());
        return "/list-cooked";
    }
    //폐자재 게시글 가져오기
    @GetMapping("item/material")
    public String materials(Model model){
//        List<Item> items = itemService.materials();
//        items.forEach(item -> {
//            model.addAttribute("item", item);
//        });
        model.addAttribute("itemlist",itemService.materials());
        return "/list-material";
    }

//    @GetMapping("item/detail")
//    public String detail(@RequestParam("id") Long id,Model model, Model model2){
//        model.addAttribute("itemlist",itemService.cookedItems());
//        model2.addAttribute("productId",id);
//        return "/product";
//    }

    @GetMapping("item/detail")
    public String detail(@RequestParam("id") Long id,Model model, Model model2, Model model3){
        model.addAttribute("itemlist",itemService.getAll());
        model2.addAttribute("productId",id);
        model3.addAttribute("locationlist",itemService.getAllLocation());
        return "/product";
    }

    @PostMapping("item/detail/{id}")
    public String getItem(ReservedItemDTO reservedItemDTO) {
        // test
//        System.out.println("reservedItemDTO.getItemId() = " + reservedItemDTO.getItemId());
//        System.out.println("reservedItemDTO.getReserved() = " + reservedItemDTO.getReserved());
        Item item = itemService.postReservation(reservedItemDTO);

        return "/product";
    }

    @PostMapping("item/detail")
    public String getItem(@RequestParam("id") Long id, Model model){
        System.out.println("the id is " + id);
        itemService.reserved(id);

        return "/home";
    }
}
