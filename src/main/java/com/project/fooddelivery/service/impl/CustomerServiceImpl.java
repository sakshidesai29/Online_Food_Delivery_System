package com.project.fooddelivery.service.impl;

import com.project.fooddelivery.entity.Customer;
import com.project.fooddelivery.repository.CustomerRepository;
import com.project.fooddelivery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public List<Customer> getAll() { return repo.findAll(); }

    @Override
    public Customer save(Customer customer) { return repo.save(customer); }

    @Override
    public Customer getById(Integer id) { return repo.findById(id).orElse(null); }

    @Override
    public void deleteById(Integer id) { repo.deleteById(id); }

    @Override
    public List<Customer> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return repo.findAll();
        return repo.search(keyword);
    }
}
