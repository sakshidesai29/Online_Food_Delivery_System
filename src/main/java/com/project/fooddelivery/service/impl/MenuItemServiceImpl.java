package com.project.fooddelivery.service.impl;

import com.project.fooddelivery.entity.MenuItem;
import com.project.fooddelivery.repository.MenuItemRepository;
import com.project.fooddelivery.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository repo;

    @Override
    public List<MenuItem> getAll() { return repo.findAll(); }

    @Override
    public MenuItem save(MenuItem item) { return repo.save(item); }

    @Override
    public MenuItem getById(Integer id) { return repo.findById(id).orElse(null); }

    @Override
    public void deleteById(Integer id) { repo.deleteById(id); }

    @Override
    public List<MenuItem> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return repo.findAll();
        return repo.search(keyword);
    }

    @Override
    public List<MenuItem> getByRestaurant(Integer restaurantId) {
        return repo.findByRestaurantId(restaurantId);
    }
}
