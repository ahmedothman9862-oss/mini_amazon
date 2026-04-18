package com.example.MiniAmazon.Repo;

import com.example.MiniAmazon.Dto.OrderDetailsDTO;
import com.example.MiniAmazon.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("""
SELECT new com.example.MiniAmazon.Dto.OrderDetailsDTO(
    u.id,
    u.mail,
    u.name,
    o.totalPrice,
    oi.quantity,
    p.name,
    p.price
)
FROM User u
JOIN u.orders o
LEFT JOIN o.items oi
LEFT JOIN oi.product p
WHERE u.id = :userId
""")
    // list cuz it multiple return
    // note : Your mistake is NOT Spring — it’s this:
        //
        //❌ Trying to flatten a 1-to-many-to-many relationship into ONE DTO result
        //
        //That almost always produces duplicates.
    //we create the order details dto linked the sql quert to be response
    List<OrderDetailsDTO> getUserOrderDetails(@Param("userId") Long userId);
}
