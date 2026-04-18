package com.example.MiniAmazon.Repo;

import com.example.MiniAmazon.Dto.OrderViewDTO;
import com.example.MiniAmazon.Dto.OrdersDTO;
import com.example.MiniAmazon.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Long> {
    // QUEREY MATCH WITH ENTITY
    @Query("""
SELECT new com.example.MiniAmazon.Dto.OrderViewDTO(
    o.id,
    u.name,
    u.mail,
    o.totalPrice,
    o.id
)
FROM Orders o
JOIN o.user u
WHERE u.id = :userId
""")
    // we create orderviewDTO THAT COMPINE THE USER AND ORDER LINKED WITH SQL AND HIBERNATE
    List<OrderViewDTO> findOrdersOfUsers(@Param("userId") Long userId);
}
