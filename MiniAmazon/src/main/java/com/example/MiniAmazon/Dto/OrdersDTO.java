package com.example.MiniAmazon.Dto;

import java.util.List;

public class OrdersDTO {
    private Long userId; // link order to existing user
    private Long id;
    private List<OrderItemDTO> items; // items in the order
    private double totalPrice; // ✅ total price of the order

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdersDTO(Long userId, List<OrderItemDTO> items, double totalPrice) {
        this.userId = userId;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrdersDTO(Long userId, List<OrderItemDTO> items) {
        this.userId = userId;
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public OrdersDTO() {
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "userId=" + userId +
                ", id=" + id +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
