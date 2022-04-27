package com.helmes.sectors.services;

import com.helmes.sectors.exceptions.NotFoundException;
import com.helmes.sectors.models.Sector;
import com.helmes.sectors.repositories.SectorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class SectorServiceTest {

    @InjectMocks
    private SectorService sectorService;

    @Mock
    private SectorRepository sectorRepository;

    @Test
    public void findById_ValidId_ShouldReturnSector() {
        Sector sector = Sector.builder()
                .id(12L)
                .name("IT").build();
        doReturn(Optional.ofNullable(sector))
                .when(sectorRepository).findById(12L);

        Sector newSector = sectorService.findById(12L);

        assertThat(sector, is(newSector));
    }

    @Test
    public void findById_InvalidId_ShouldThrowException() {
        doThrow(new NotFoundException("Sector not found"))
                .when(sectorRepository).findById(12L);

        assertThatThrownBy(() -> sectorService.findById(12L))
                .isInstanceOf(NotFoundException.class);
    }
}