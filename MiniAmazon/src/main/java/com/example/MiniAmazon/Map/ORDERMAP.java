package com.example.MiniAmazon.Map;

import com.example.MiniAmazon.Dto.OrderItemDTO;
import com.example.MiniAmazon.Dto.OrdersDTO;
import com.example.MiniAmazon.Entity.OrderItems;
import com.example.MiniAmazon.Entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ORDERMAP {
    // ORDERS
    Orders toEndity(OrdersDTO dto);
    @Mapping(source = "user.id", target = "userId")
    OrdersDTO toDto(Orders orders);
    List<OrdersDTO> toDtolist(List<Orders> orders);

    //ORDERitems
    OrderItems toEntityItem(OrderItemDTO orderItemsdto);
    @Mapping(source = "product.id", target = "productId")
    OrderItemDTO toDtoItem(OrderItems orderItems);
    List<OrderItemDTO> toDtoList(List<OrderItems> orderItems);
}
