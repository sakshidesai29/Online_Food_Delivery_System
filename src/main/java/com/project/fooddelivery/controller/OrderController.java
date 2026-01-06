package com.project.fooddelivery.controller;

import com.project.fooddelivery.entity.*;
import com.project.fooddelivery.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MenuItemService menuService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false) String keyword) {
        model.addAttribute("list", orderService.search(keyword));
        model.addAttribute("keyword", keyword);
        return "order-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("order", new OrderEntity());
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("menuItems", menuService.getAll());
        return "order-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("order", orderService.getById(id));
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("menuItems", menuService.getAll());
        return "order-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute OrderEntity order, @RequestParam(required = false) List<Integer> itemIds, @RequestParam(required = false) List<Integer> quantities) {
        // Build order items and compute total
        List<OrderItem> items = new ArrayList<>();
        double total = 0.0;
        if (itemIds != null && quantities != null && itemIds.size() == quantities.size()) {
            for (int i = 0; i < itemIds.size(); i++) {
                MenuItem mi = menuService.getById(itemIds.get(i));
                int qty = quantities.get(i);
                if (mi != null) {
                    double price = mi.getPrice() * qty;
                    OrderItem oi = new OrderItem(mi.getName(), qty, price);
                    items.add(oi);
                    total += price;
                }
            }
        }
        order.setItems(items);
        order.setTotalAmount(total);
        order.setOrderDate(LocalDate.now());
        if (order.getStatus() == null || order.getStatus().trim().isEmpty()) order.setStatus("Placed");
        orderService.save(order);
        return "redirect:/order/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        orderService.deleteById(id);
        return "redirect:/order/list";
    }
}
