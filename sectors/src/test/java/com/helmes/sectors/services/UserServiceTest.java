package com.helmes.sectors.services;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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
        UserDTO userDTO = UserDTO.builder().name("Victor").agreeTerms(true).sectorValue(1L).build();
        Sector sector = Sector.builder().id(1L).name("IT").build();
        User user = User.builder().name("Victor").agreeTerms(true).sector(sector).build();

        when(sectorService.findById(1L))
                .thenReturn(sector);
        when(userRepository.save(user)).thenReturn(user);
        UserDTO newUser = userService.save(userDTO);

        assertThat(newUser.getSectorValue(), is(1L));
        assertThat(newUser.getName(), is(userDTO.getName()));
        assertThat(newUser.getAgreeTerms(), is(true));
    }

    @Test
    public void save_invvalidData_shouldThrowException() {
        UserDTO userDTO = UserDTO.builder().name("Victor").agreeTerms(true).sectorValue(1L).build();

        doThrow(new NotFoundException("Sector not found"))
                .when(sectorService).findById(1L);

        assertThatThrownBy(() -> userService.save(userDTO))
                .isInstanceOf(NotFoundException.class);
    }
}