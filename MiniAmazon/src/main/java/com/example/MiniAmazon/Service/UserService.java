package com.example.MiniAmazon.Service;

import com.example.MiniAmazon.Dto.OrderDetailsDTO;
import com.example.MiniAmazon.Dto.UserDTO;
import com.example.MiniAmazon.Entity.User;
import com.example.MiniAmazon.Map.USERMAP;
import com.example.MiniAmazon.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInterface {
private final UserRepo userRepo;
    private USERMAP usermap;
@Autowired
    public UserService(UserRepo userRepo , USERMAP usermap) {
        this.userRepo = userRepo;
        this.usermap = usermap;
    }
    @CachePut(value = "USER_CACHE" , key = "#result.id")
    @Override
    public UserDTO addUser(UserDTO userDTO) {
 /*   User user = new User();
    user.setId(userDTO.getId());
    user.setName(userDTO.getName());
    user.setMail(userDTO.getMail());
    // save entity
    User save = userRepo.save(user);
    // map to dto
    UserDTO dto  = new UserDTO();
    dto.setId(save.getId());
    dto.setName(save.getName());
    dto.setMail(save.getMail());
return dto;*/
        User user = usermap.toEntity(userDTO);
        User save = userRepo.save(user);
        return usermap.toDTO(save);
    }

    @Override
    public List <OrderDetailsDTO> getUserOrderDetails(long id) {

        return userRepo.getUserOrderDetails(id);
    }
}
