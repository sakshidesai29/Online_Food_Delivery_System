package com.project.fooddelivery.service.impl;

import com.project.fooddelivery.entity.Restaurant;
import com.project.fooddelivery.repository.RestaurantRepository;
import com.project.fooddelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repo;

    @Override
    public List<Restaurant> getAll() { return repo.findAll(); }

    @Override
    public Restaurant save(Restaurant r) { return repo.save(r); }

    @Override
    public Restaurant getById(Integer id) { return repo.findById(id).orElse(null); }

    @Override
    public void deleteById(Integer id) { repo.deleteById(id); }

    @Override
    public List<Restaurant> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return repo.findAll();
        return repo.search(keyword);
    }
}
