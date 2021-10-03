package com.ApricotMarket.repository;

import com.ApricotMarket.domain.Category;
import com.ApricotMarket.domain.Item;
import com.ApricotMarket.domain.Location;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    void create(Item item);
    void createLocation(Location location);
    List<Item> findByLocation(String city, String district, String town);
    List<Item> findByName(String name); // 업체명 검색
    List<Item> findByPdn(String name); // 물품명 검색
    List<Item> findByCategory(Category name);
    Optional<Item> findByItemId(Long itemId);
    int setReservedTrue(Long itemId);
    List<Item> getAll();
    List<Item> getAllDesc();
    List<Location> getAllLocation();
}
