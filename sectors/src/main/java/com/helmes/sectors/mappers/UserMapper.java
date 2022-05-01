package com.helmes.sectors.mappers;

import com.helmes.sectors.dto.UserDTO;
import com.helmes.sectors.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userDtoToUser(UserDTO userDTO);
    UserDTO userToUserDto(User user);
}
