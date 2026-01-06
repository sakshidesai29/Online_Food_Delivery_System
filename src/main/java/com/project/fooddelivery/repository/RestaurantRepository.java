package com.project.fooddelivery.repository;

import com.project.fooddelivery.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("SELECT r FROM Restaurant r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(r.cuisine) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Restaurant> search(String keyword);
}
