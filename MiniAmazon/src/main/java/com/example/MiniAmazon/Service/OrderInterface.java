package com.example.MiniAmazon.Service;

import com.example.MiniAmazon.Dto.OrderViewDTO;
import com.example.MiniAmazon.Dto.OrdersDTO;

import java.util.List;

public interface OrderInterface  {
    OrdersDTO createOrder(OrdersDTO dto);
    OrdersDTO findOrder(long id);
    List<OrderViewDTO> findOrdersOfUsers(long id);
    List<OrdersDTO>findall();
}
