package com.example.MiniAmazon.Service;

import com.example.MiniAmazon.Dto.OrderItemDTO;
import com.example.MiniAmazon.Dto.OrderViewDTO;
import com.example.MiniAmazon.Dto.OrdersDTO;
import com.example.MiniAmazon.Dto.ProductDTO;
import com.example.MiniAmazon.Entity.OrderItems;
import com.example.MiniAmazon.Entity.Orders;
import com.example.MiniAmazon.Entity.Product;
import com.example.MiniAmazon.Entity.User;
import com.example.MiniAmazon.Map.ORDERMAP;
import com.example.MiniAmazon.Repo.OrderRepo;
import com.example.MiniAmazon.Repo.ProductRepo;
import com.example.MiniAmazon.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderInterface {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private ORDERMAP ordermap;
    @Autowired

    public OrderService(OrderRepo orderRepo , UserRepo userRepo , ProductRepo productRepo ,ORDERMAP ordermap) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.ordermap = ordermap;
    }
    @Override
    public OrdersDTO createOrder (OrdersDTO dto){
        // CHECK IF THE USER FOUND EX USER_ID = 1 FOUND ADD THESE ORDER
        User user = userRepo.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Orders order = new Orders();
        // convenience method links user -> order
        user.addOrder(order);

        //ORDERITMES
        for (OrderItemDTO itemDTO : dto.getItems()){
            Product product = productRepo.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            OrderItems orderItems1 = ordermap.toEntityItem(itemDTO);
            orderItems1.setProduct(product); // SET MANUAL
            order.addItem(orderItems1); // CONVINCE METHOD
        }
        // calculate total
        double total = order.getItems().stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();
        order.setTotalPrice(total);

        //CONVERT and save order
        Orders savedOrder = orderRepo.save(order);
        return ordermap.toDto(savedOrder);

        // note order is the main we add product and order item to it
    }

    @Override
    public OrdersDTO findOrder(long id) {
    Orders orders  = orderRepo.findById(id).orElseThrow(()-> new RuntimeException("order not found"));
     return ordermap.toDto(orders);
    }

    @Override
    public List<OrderViewDTO> findOrdersOfUsers(long id) {

        return  orderRepo.findOrdersOfUsers(id);
    }

    @Override
    public List<OrdersDTO> findall() {
        List<Orders> orders  = orderRepo.findAll();
        return ordermap.toDtolist(orders);
    }
}

