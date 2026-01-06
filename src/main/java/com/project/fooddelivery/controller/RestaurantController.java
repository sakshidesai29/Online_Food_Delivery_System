package com.project.fooddelivery.controller;

import com.project.fooddelivery.entity.Restaurant;
import com.project.fooddelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false) String keyword) {
        model.addAttribute("list", service.search(keyword));
        model.addAttribute("keyword", keyword);
        return "restaurant-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("restaurant", service.getById(id));
        return "restaurant-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Restaurant restaurant) {
        service.save(restaurant);
        return "redirect:/restaurant/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/restaurant/list";
    }
}
