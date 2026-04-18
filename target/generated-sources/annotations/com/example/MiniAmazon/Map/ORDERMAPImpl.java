package com.example.MiniAmazon.Map;

import com.example.MiniAmazon.Dto.OrderItemDTO;
import com.example.MiniAmazon.Dto.OrdersDTO;
import com.example.MiniAmazon.Entity.OrderItems;
import com.example.MiniAmazon.Entity.Orders;
import com.example.MiniAmazon.Entity.Product;
import com.example.MiniAmazon.Entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-15T23:44:41+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class ORDERMAPImpl implements ORDERMAP {

    @Override
    public Orders toEndity(OrdersDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setId( dto.getId() );
        orders.setTotalPrice( dto.getTotalPrice() );
        orders.setItems( orderItemDTOListToOrderItemsList( dto.getItems() ) );

        return orders;
    }

    @Override
    public OrdersDTO toDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDTO ordersDTO = new OrdersDTO();

        ordersDTO.setUserId( ordersUserId( orders ) );
        ordersDTO.setId( orders.getId() );
        ordersDTO.setTotalPrice( orders.getTotalPrice() );
        ordersDTO.setItems( toDtoList( orders.getItems() ) );

        return ordersDTO;
    }

    @Override
    public List<OrdersDTO> toDtolist(List<Orders> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrdersDTO> list = new ArrayList<OrdersDTO>( orders.size() );
        for ( Orders orders1 : orders ) {
            list.add( toDto( orders1 ) );
        }

        return list;
    }

    @Override
    public OrderItems toEntityItem(OrderItemDTO orderItemsdto) {
        if ( orderItemsdto == null ) {
            return null;
        }

        OrderItems orderItems = new OrderItems();

        orderItems.setQuantity( orderItemsdto.getQuantity() );

        return orderItems;
    }

    @Override
    public OrderItemDTO toDtoItem(OrderItems orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setProductId( orderItemsProductId( orderItems ) );
        orderItemDTO.setQuantity( orderItems.getQuantity() );

        return orderItemDTO;
    }

    @Override
    public List<OrderItemDTO> toDtoList(List<OrderItems> orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        List<OrderItemDTO> list = new ArrayList<OrderItemDTO>( orderItems.size() );
        for ( OrderItems orderItems1 : orderItems ) {
            list.add( toDtoItem( orderItems1 ) );
        }

        return list;
    }

    protected List<OrderItems> orderItemDTOListToOrderItemsList(List<OrderItemDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItems> list1 = new ArrayList<OrderItems>( list.size() );
        for ( OrderItemDTO orderItemDTO : list ) {
            list1.add( toEntityItem( orderItemDTO ) );
        }

        return list1;
    }

    private Long ordersUserId(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        User user = orders.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long orderItemsProductId(OrderItems orderItems) {
        if ( orderItems == null ) {
            return null;
        }
        Product product = orderItems.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
