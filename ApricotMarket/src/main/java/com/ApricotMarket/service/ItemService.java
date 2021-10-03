package com.ApricotMarket.service;

import com.ApricotMarket.controller.createItemForm;
import com.ApricotMarket.domain.Category;
import com.ApricotMarket.domain.Item;
import com.ApricotMarket.domain.Location;
import com.ApricotMarket.dto.ReservedItemDTO;

import java.util.List;

public interface ItemService {
    void createItem(createItemForm form);
    List<Item> searchByLocation(String city, String district, String town);
    List<Item> searchByItem(String name);
    List<Item> ingredients();
    List<Item> cookedItems();
    List<Item> materials();
    List<Item> recentItems();
    Category convertToType(String str);
    public Item postReservation(ReservedItemDTO reservedItemDTO);
    int reserved(Long id);
    List<Item> getAll();
    List<Location> getAllLocation();
}
