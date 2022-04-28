package com.restaurantapp.repository;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer> {

    List<Restaurant> findByItemType(Type itemType);
    List<Restaurant> findByRating(double rating);
    List<Restaurant> findByCity(String city);

    // custom queries
    @Query("from Restaurant r inner join r.items i where i.name=?1")
    List<Restaurant> findByName(String name);
    @Query("from Restaurant r inner join r.items i where r.name=?1 and i.category=?2")
    List<Restaurant> findByNameCategory(String name, Category category);
    @Query("from Restaurant r inner join r.items i where i.cuisine=?1")
    List<Restaurant> findByCuisine(Cuisine cuisine);
    @Query("from Restaurant r inner join r.items i where i.category=?1")
    List<Restaurant> findByCategory(Category category);
    @Query("from Restaurant r inner join r.items i where i.cuisine=?1 and i.itemType=?2")
    List<Restaurant> findByCuisineAndType(Cuisine cuisine, Type type);
    @Query("from Restaurant r inner join r.items i where i.name=?1 and i.price=?2")
    List<Restaurant> findByNameLessPrice(String name, double price);
}
