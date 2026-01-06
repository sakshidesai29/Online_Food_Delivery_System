package com.project.fooddelivery.service;

import com.project.fooddelivery.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer save(Customer customer);
    Customer getById(Integer id);
    void deleteById(Integer id);
    List<Customer> search(String keyword);
}
