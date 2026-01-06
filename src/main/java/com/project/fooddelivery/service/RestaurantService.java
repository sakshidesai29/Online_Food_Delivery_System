package com.project.fooddelivery.service;

import com.project.fooddelivery.entity.Restaurant;
import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAll();
    Restaurant save(Restaurant r);
    Restaurant getById(Integer id);
    void deleteById(Integer id);
    List<Restaurant> search(String keyword);
}
