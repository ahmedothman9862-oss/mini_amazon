package com.example.MiniAmazon.Map;

import com.example.MiniAmazon.Dto.UserDTO;
import com.example.MiniAmazon.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface USERMAP {
    User toEntity(UserDTO dto);
    UserDTO toDTO(User user);
}
