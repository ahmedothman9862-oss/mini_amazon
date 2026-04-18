package com.example.MiniAmazon.Entity;

import com.example.MiniAmazon.Dto.ProductDTO;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private  double price; // ✅ Add this line

    public OrderItems() {
    }

    // Many order items belong to one order
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;


    // Many items reference one product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItems(int quantity, Orders order, Product product) {
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public OrderItems(int quantity, Orders order) {
        this.quantity = quantity;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product ) {
        this.product = product;
        this.price = product.getPrice(); // set price at the time of ordering
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
