package com.project.fooddelivery.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate orderDate;
    private String status; // Placed, Preparing, Delivered, Cancelled
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // we will not persist full order items cascade complexity for simplicity, but include a OneToMany
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    public OrderEntity() {}

    public OrderEntity(LocalDate orderDate, String status, double totalAmount, Customer customer, List<OrderItem> items) {
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.items = items;
    }

    // getters & setters...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}
