package com.project.fooddelivery.controller;

import com.project.fooddelivery.entity.Customer;
import com.project.fooddelivery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false) String keyword) {
        model.addAttribute("list", service.search(keyword));
        model.addAttribute("keyword", keyword);
        return "customer-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", service.getById(id));
        return "customer-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer) {
        service.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/customer/list";
    }
}
