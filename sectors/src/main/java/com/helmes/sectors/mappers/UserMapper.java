package com.helmes.sectors.mappers;

import com.helmes.sectors.dto.UserDTO;
import com.helmes.sectors.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {

    User userDtoToUser(UserDTO userDTO);

    @Mappings({
            @Mapping(target = "sectorValue", source = "user.sector.id"),
    })
    UserDTO userToUserDto(User user);
}
