package com.project.fooddelivery.controller;

import com.project.fooddelivery.entity.MenuItem;
import com.project.fooddelivery.entity.Restaurant;
import com.project.fooddelivery.service.MenuItemService;
import com.project.fooddelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuItemController {

    @Autowired
    private MenuItemService menuService;

    @Autowired
    private RestaurantService restService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false) String keyword) {
        model.addAttribute("list", menuService.search(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("restaurants", restService.getAll());
        return "menu-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("menuItem", new MenuItem());
        model.addAttribute("restaurants", restService.getAll());
        return "menu-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("menuItem", menuService.getById(id));
        model.addAttribute("restaurants", restService.getAll());
        return "menu-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MenuItem menuItem) {
        menuService.save(menuItem);
        return "redirect:/menu/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        menuService.deleteById(id);
        return "redirect:/menu/list";
    }

    @GetMapping("/by-restaurant/{rid}")
    public String byRestaurant(@PathVariable Integer rid, Model model) {
        List<MenuItem> list = menuService.getByRestaurant(rid);
        model.addAttribute("list", list);
        model.addAttribute("restaurants", restService.getAll());
        return "menu-list";
    }
}
