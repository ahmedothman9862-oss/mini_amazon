package com.example.MiniAmazon.Service;

import com.example.MiniAmazon.Dto.OrderDetailsDTO;
import com.example.MiniAmazon.Dto.UserDTO;

import java.util.List;

public interface UserInterface {
    UserDTO addUser(UserDTO userDTO);
   List<OrderDetailsDTO> getUserOrderDetails(long id);
}
