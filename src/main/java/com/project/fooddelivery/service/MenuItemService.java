package com.project.fooddelivery.service;

import com.project.fooddelivery.entity.MenuItem;
import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAll();
    MenuItem save(MenuItem item);
    MenuItem getById(Integer id);
    void deleteById(Integer id);
    List<MenuItem> search(String keyword);
    List<MenuItem> getByRestaurant(Integer restaurantId);
}
