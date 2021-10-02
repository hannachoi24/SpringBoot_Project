package com.ApricotMarket.repository;

import com.ApricotMarket.domain.Category;
import com.ApricotMarket.domain.Item;
import com.ApricotMarket.domain.Location;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class ItemMemoryRepository implements ItemRepository{
    public ItemMemoryRepository(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;

    @Override
    public void create(Item item) {
        em.persist(item);
    }

    @Override
    public void createLocation(Location location) {
        em.persist(location);
    }

    @Override
    public List<Item> findByLocation(String city, String district, String town) {
        Location location = em.createQuery("select l from Location l where l.city = :city and l.district = :district and l.town =:town", Location.class)
                .setParameter("city", city).setParameter("district", district).setParameter("town", town)
                .getSingleResult();

        List<Item> resultList = em.createQuery("select i from Item i where i.location = :location", Item.class)
                .setParameter("location",location)
                .getResultList();
        return resultList;
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> resultList = em.createQuery("select i from Item i where i.name like :name", Item.class)
                .setParameter("name", "%"+name+"%")
                .getResultList();
        return resultList;
    }

    @Override
    public List<Item> findByPdn(String name) {
        System.out.println("repo: " + name);
        List<Item> resultList = em.createQuery("select i from Item i where i.pdn like :name", Item.class)
                .setParameter("name", "%"+name+"%")
                .getResultList();
        return resultList;
    }

    @Override
    public List<Item> findByCategory(Category name) {
        List<Item> resultList = em.createQuery("select i from Item i where i.category =:name", Item.class)
                .setParameter("name", name)
                .getResultList();
        return resultList;
    }

//    @Override
//    public List AllLocation(){
//        List resultList = em.createQuery("select i,l from Item i inner join i.location l")
//                .getResultList();
//
//        return resultList;
//    }

    @Override
    public Optional<Item> findByItemId(Long itemId) {
        Optional<Item> resultList = em.createQuery("select id from Item where id =:id", Item.class)
                .setParameter("id", itemId)
                .getResultList().stream().findFirst();
        return  resultList;
    }


    @Modifying
    @Override
    public int setReservedTrue(Long itemId){
        int m = em.createQuery("update Item w set w.reserved=1 where w.id =:id")
                .setParameter("id", itemId)
                .executeUpdate();

        return m;
    }

    @Override
    public List<Item> getAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    @Override
    public List<Item> getAllDesc() {
        return em.createQuery("select i from Item i ORDER BY i.id DESC", Item.class)
                .getResultList();
    }

    @Override
    public List<Location> getAllLocation() {
        return em.createQuery("select i from Location i", Location.class)
                .getResultList();
    }

//    @Override
//    public List fBC(){
//        List resultList = em.createQuery("select i,l from Item i inner join i.location l")
//                .getResultList();
//
//        return resultList;
//    }

//    @Override
//    @Modifying
//    @Query("UPDATE Item w set w.reserved=1 where w.id =:id")
//    void setReservedTrue(@Param("id") Long itemId){
//
//    }
}
