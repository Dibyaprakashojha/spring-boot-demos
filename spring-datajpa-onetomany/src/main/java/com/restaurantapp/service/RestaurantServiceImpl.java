package com.restaurantapp.service;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;
import com.restaurantapp.repository.IRestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantServiceImpl implements IRestaurantService{
    private final IRestaurantRepository iRestaurantRepository;

    public RestaurantServiceImpl(IRestaurantRepository iRestaurantRepository) {
        this.iRestaurantRepository = iRestaurantRepository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return iRestaurantRepository.save(restaurant);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        iRestaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        iRestaurantRepository.deleteById(restaurantId);
    }

    @Override
    public List<Restaurant> getAll() {
        return iRestaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getByItemType(Type itemType) {
        return iRestaurantRepository.findByItemType(itemType);
    }

    @Override
    public List<Restaurant> getByRating(double rating) {
        return iRestaurantRepository.findByRating(rating);
    }

    @Override
    public List<Restaurant> getByCity(String city) {
        return iRestaurantRepository.findByCity(city);
    }
//
    @Override
    public List<Restaurant> getByName(String name) {
        return iRestaurantRepository.findByName(name);
    }

    @Override
    public List<Restaurant> getByNameCategory(String name, Category category) {
        return iRestaurantRepository.findByNameCategory(name, category);
    }

    @Override
    public List<Restaurant> getByCuisine(Cuisine cuisine) {
        return iRestaurantRepository.findByCuisine(cuisine);
    }

    @Override
    public List<Restaurant> getByCategory(Category category) {
        return iRestaurantRepository.findByCategory(category);
    }

    @Override
    public List<Restaurant> getByCuisineAndType(Cuisine cuisine, Type type) {
        return iRestaurantRepository.findByCuisineAndType(cuisine, type);
    }

    @Override
    public List<Restaurant> getByNameLessPrice(String name, double price) {
        return iRestaurantRepository.findByNameLessPrice(name, price);
    }
}
