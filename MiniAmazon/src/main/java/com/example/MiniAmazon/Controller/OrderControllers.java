package com.example.MiniAmazon.Controller;

import com.example.MiniAmazon.Dto.OrderViewDTO;
import com.example.MiniAmazon.Dto.OrdersDTO;
import com.example.MiniAmazon.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderControllers {
private final OrderService orderService;

@Autowired
    public OrderControllers(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public OrdersDTO create(@RequestBody OrdersDTO ordersDTO){
    return orderService.createOrder(ordersDTO);
    }
    @GetMapping("/{id}")
    public  OrdersDTO find(@PathVariable long id){
    return orderService.findOrder(id);
    }
    @GetMapping("/orderDetails/{id}")
    public List<OrderViewDTO> findOrderDetail(@PathVariable long id){
    return  orderService.findOrdersOfUsers(id);
    }
    @GetMapping("/orders")
    public List<OrdersDTO> findall(){
    return orderService.findall();
    }
}
