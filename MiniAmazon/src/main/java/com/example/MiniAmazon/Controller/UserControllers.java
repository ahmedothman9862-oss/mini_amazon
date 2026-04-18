package com.example.MiniAmazon.Controller;

import com.example.MiniAmazon.Dto.OrderDetailsDTO;
import com.example.MiniAmazon.Dto.UserDTO;
import com.example.MiniAmazon.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserControllers {
private final UserService userService;
    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO dto){
        return userService.addUser(dto);
    }
    @GetMapping("/find/{id}")
    public List<OrderDetailsDTO> get(@PathVariable long id){
        return userService.getUserOrderDetails(id);
    }
}
