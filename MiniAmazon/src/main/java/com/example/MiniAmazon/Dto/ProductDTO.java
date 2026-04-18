package com.example.MiniAmazon.Dto;

public class ProductDTO {

    private String name;


    private double price;


    private Long id;
    public ProductDTO() {
    }


    public ProductDTO(String name, double price , Long id) {
        this.name = name;
        this.price = price;
        this.id=id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
