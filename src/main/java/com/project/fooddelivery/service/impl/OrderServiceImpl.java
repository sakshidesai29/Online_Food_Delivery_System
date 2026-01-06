package com.project.fooddelivery.service.impl;

import com.project.fooddelivery.entity.OrderEntity;
import com.project.fooddelivery.repository.OrderRepository;
import com.project.fooddelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repo;

    @Override
    public List<OrderEntity> getAll() { return repo.findAll(); }

    @Override
    public OrderEntity save(OrderEntity order) { return repo.save(order); }

    @Override
    public OrderEntity getById(Integer id) { return repo.findById(id).orElse(null); }

    @Override
    public void deleteById(Integer id) { repo.deleteById(id); }

    @Override
    public List<OrderEntity> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return repo.findAll();
        return repo.search(keyword);
    }
}
