package com.restaurantapp.service;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;

import java.util.List;

public interface IRestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(int restaurantId);
    List<Restaurant> getAll();

    //derived queries
    List<Restaurant> getByItemType(Type itemType);
    List<Restaurant> getByRating(double rating);
    List<Restaurant> getByCity(String city);

    // custom queries

    List<Restaurant> getByName(String name);
    List<Restaurant> getByNameCategory(String name, Category category);
    List<Restaurant> getByCuisine(Cuisine cuisine);
    List<Restaurant> getByCategory(Category category);
    List<Restaurant> getByCuisineAndType(Cuisine cuisine, Type type);
    List<Restaurant> getByNameLessPrice(String name, double price);

}
