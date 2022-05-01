package com.helmes.sectors.services;

import com.helmes.sectors.dto.SectorDTO;
import com.helmes.sectors.dto.UserDTO;
import com.helmes.sectors.exceptions.NotFoundException;
import com.helmes.sectors.mappers.UserMapper;
import com.helmes.sectors.models.Sector;
import com.helmes.sectors.models.User;
import com.helmes.sectors.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper MAPPER_INSTANCE = Mappers.getMapper( UserMapper.class );
    private final UserRepository userRepository;
    private final SectorService sectorService;

    public UserDTO save(UserDTO userDTO) {
        User user = MAPPER_INSTANCE.userDtoToUser(userDTO);
        Sector sector = sectorService.findById(userDTO.getSector().getId());
        user.setSector(sector);
        return MAPPER_INSTANCE.userToUserDto(userRepository.save(user));
    }

    public List<UserDTO> listAll() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userRepository.findAll()
                .stream()
                .map(MAPPER_INSTANCE::userToUserDto)
                .collect(Collectors.toCollection(() -> userDTOList));
        return userDTOList;
    }

    public UserDTO updateUser(SectorDTO sectorDTO, Long userId) {
        User user = userRepository.findById(userId)
                .map(updateUser -> {
                    Sector sector = sectorService.findById(sectorDTO.getId());
                    updateUser.setSector(sector);
                    return userRepository.save(updateUser);
                }).orElseThrow(() -> new NotFoundException("User Not Found"));
        return MAPPER_INSTANCE.userToUserDto(user);
    }
}
