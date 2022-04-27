package com.helmes.sectors.services;

import com.helmes.sectors.dto.UserDTO;
import com.helmes.sectors.mappers.UserMapper;
import com.helmes.sectors.models.Sector;
import com.helmes.sectors.models.User;
import com.helmes.sectors.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper MAPPER_INSTANCE = Mappers.getMapper( UserMapper.class );
    private final UserRepository userRepository;
    private final SectorService sectorService;

    public UserDTO save(UserDTO userDTO) {
        User user = MAPPER_INSTANCE.userDtoToUser(userDTO);
        Sector sector = sectorService.findById(userDTO.getSectorValue());
        user.setSector(sector);
        return MAPPER_INSTANCE.userToUserDto(userRepository.save(user));
    }
}
