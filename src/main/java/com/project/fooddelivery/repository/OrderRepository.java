package com.project.fooddelivery.repository;

import com.project.fooddelivery.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Query("SELECT o FROM OrderEntity o WHERE LOWER(o.status) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(o.customer.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<OrderEntity> search(String keyword);
}
