package com.example.MiniAmazon.Dto;

public class OrderDetailsDTO    {
    private Long userId;
    private String email;
    private String userName;
    private Double totalPrice;
    private Integer quantity;
    private String productName;
    private Double price;

    public OrderDetailsDTO(Long userId, String email, String userName,
                           Double totalPrice, Integer quantity,
                           String productName, Double price) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
