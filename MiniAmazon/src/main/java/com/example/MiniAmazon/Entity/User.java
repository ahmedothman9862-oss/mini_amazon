package com.example.MiniAmazon.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private  String name;

    @Column(name = "email")
    private  String mail;

    // One user can have many orders
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> orders;

    public User() {
    }

    public User(String name, String mail, List<Orders> orders) {
        this.name = name;
        this.mail = mail;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", orders=" + orders +
                '}';
    }

    // LINK
    public void addOrder(Orders order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);        // add to user's list
        order.setUser(this);      // set the back-reference automatically
    }
}
