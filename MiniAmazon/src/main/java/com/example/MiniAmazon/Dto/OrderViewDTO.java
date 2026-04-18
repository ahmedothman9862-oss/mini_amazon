package com.example.MiniAmazon.Dto;

public class OrderViewDTO {
    private Long id;
    private String customerName;
    private String email;
    private double totalPrice;
    private Long orderid;

    public OrderViewDTO(Long id, String customerName, String email, double totalPrice,Long orderid) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.totalPrice = totalPrice;
        this.orderid = orderid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }
}
