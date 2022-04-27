package com.helmes.sectors.repositories;

import com.helmes.sectors.models.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

    Optional<Sector> findById(Long uuid);
}
