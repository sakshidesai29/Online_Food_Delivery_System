package com.project.fooddelivery.service;

import com.project.fooddelivery.entity.OrderEntity;
import java.util.List;

public interface OrderService {
    List<OrderEntity> getAll();
    OrderEntity save(OrderEntity order);
    OrderEntity getById(Integer id);
    void deleteById(Integer id);
    List<OrderEntity> search(String keyword);
}
