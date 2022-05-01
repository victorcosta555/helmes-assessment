package com.helmes.sectors.services;

import com.helmes.sectors.dto.SectorDTO;
import com.helmes.sectors.dto.UserDTO;
import com.helmes.sectors.exceptions.NotFoundException;
import com.helmes.sectors.models.Sector;
import com.helmes.sectors.models.User;
import com.helmes.sectors.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SectorService sectorService;

    @Test
    public void save_validData_shouldReturnValidUserDTO() {
        SectorDTO sectorDTO = SectorDTO.builder().id(1L).build();
        UserDTO userDTO = UserDTO.builder().name("Victor").agreeTerms(true).sector(sectorDTO).build();

        Sector sector = Sector.builder().id(1L).name("IT").build();
        User user = User.builder().name("Victor").agreeTerms(true).sector(sector).build();

        when(sectorService.findById(1L))
                .thenReturn(sector);
        when(userRepository.save(user)).thenReturn(user);
        UserDTO newUser = userService.save(userDTO);

        assertThat(newUser.getSector().getId(), is(1L));
        assertThat(newUser.getName(), is(userDTO.getName()));
        assertThat(newUser.getAgreeTerms(), is(true));
    }

    @Test
    public void save_invvalidData_shouldThrowException() {
        SectorDTO sectorDTO = SectorDTO.builder().id(1L).build();
        UserDTO userDTO = UserDTO.builder().name("Victor").agreeTerms(true).sector(sectorDTO).build();

        doThrow(new NotFoundException("Sector not found"))
                .when(sectorService).findById(1L);

        assertThatThrownBy(() -> userService.save(userDTO))
                .isInstanceOf(NotFoundException.class);
    }

    @Test
    public void listAll_listAllUsers_shouldReturnAllUsers() {
        Sector sector = Sector.builder().id(1L).name("IT").build();
        User user = User.builder().name("Victor").agreeTerms(true).sector(sector).build();

        List<User> userList = Collections.singletonList(user);
        when(userRepository.findAll()).thenReturn(userList);

        List<UserDTO> response = userService.listAll();

        assertThat(response, hasSize(1));
    }

    @Test
    public void updateUser_validData_shouldReturnUpdatedUserDTO() {
        Sector oldSector = Sector.builder().id(1L).name("IT").build();
        Sector updateSector = Sector.builder().id(43L).name("Beverages").build();
        User user = User.builder().id(12L).name("Victor").agreeTerms(true).sector(oldSector).build();

        when(userRepository.findById(12L)).thenReturn(Optional.of(user));
        when(sectorService.findById(43L)).thenReturn(updateSector);
        user.setSector(updateSector);
        when(userRepository.save(user)).thenReturn(user);

        UserDTO userDTO = userService.updateUser(SectorDTO.builder().id(43L).build(), 12L);

        assertThat(userDTO.getSector().getId(), is(43L));
    }
}