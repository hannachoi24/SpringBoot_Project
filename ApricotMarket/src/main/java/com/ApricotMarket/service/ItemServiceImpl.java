package com.ApricotMarket.service;

import com.ApricotMarket.controller.createItemForm;
import com.ApricotMarket.domain.Item;
import com.ApricotMarket.domain.Location;
import com.ApricotMarket.dto.ReservedItemDTO;
import com.ApricotMarket.repository.ItemRepository;
import com.ApricotMarket.domain.Category;
import org.aspectj.weaver.ast.Not;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemServiceImpl implements ItemService{

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    private final ItemRepository itemRepository;



    @Override
    public void createItem(createItemForm form) {
        Item item = new Item();
        item.setName(form.getName());
        item.setCategory(form.getCategory());
        item.setDescription(form.getDescription());
        item.setImage(form.getImage());
        item.setPdn(form.getPdn());

        Location location = new Location();
        location.setCity(form.getCity());
        location.setDistrict(form.getDistrict());
        location.setTown(form.getTown());

        item.setLocation(location);
        item.setExpiryDate(form.getExpiryDate());
        item.setPrice(form.getPrice());
        this.itemRepository.createLocation(location);
        this.itemRepository.create(item);
    }

    @Override
    public List<Item> searchByLocation(String city, String district, String town) {
        return this.itemRepository.findByLocation(city, district, town);
    }


    @Override
    public List<Item> searchByItem(String name) {
        return this.itemRepository.findByPdn(name);
    }
    @Override
    public Category convertToType(String str) {
        return Category.valueOf(str);
    }
    @Override
    public List<Item> ingredients() {
        return this.itemRepository.findByCategory(Category.INGREDIENTS);
    }

    @Override
    public List<Item> cookedItems() {
       return this.itemRepository.findByCategory(Category.COOKED);
    }

    @Override
    public List<Item> materials() {
        return this.itemRepository.findByCategory(Category.MATERIAL);
    }

    @Override
    public List<Item> recentItems() {
        List<Item> result = this.itemRepository.getAllDesc();
        if(result.size() >= 4) {
            return this.itemRepository.getAllDesc().subList(0, 4);
        }
        else {
            return this.itemRepository.getAllDesc();
        }
    }

    @Override
    public Item postReservation(ReservedItemDTO reservedItemDTO) {
        Long itemId = reservedItemDTO.getItemId();
        Boolean reserved = reservedItemDTO.getReserved();

        Item item = itemRepository.findByItemId(itemId).orElse(null);
        item.setReserved(reserved);

        return item;
    }

    @Override
    public List<Item> getAll(){
        return this.itemRepository.getAll();
    }

    @Override
    public List<Location> getAllLocation(){
        return this.itemRepository.getAllLocation();
    }

    @Transactional
    @Override
    public int reserved(Long id){
        return this.itemRepository.setReservedTrue(id);
    }
}
