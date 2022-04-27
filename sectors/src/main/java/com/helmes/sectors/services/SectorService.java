package com.helmes.sectors.services;

import com.helmes.sectors.exceptions.NotFoundException;
import com.helmes.sectors.models.Sector;
import com.helmes.sectors.repositories.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectorService {

    private final SectorRepository sectorRepository;

    public Sector findById(Long uuid) {
        return sectorRepository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Sector Not Found"));
    }
}
