package com.helmes.sectors.dto;

import com.helmes.sectors.models.Sector;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    @NotNull(message = "Name is mandatory")
    @NotEmpty(message = "Name is mandatory")
    public String name;

    @NotNull(message = "Sector is mandatory")
    private SectorDTO sector;

    @NotNull
    public Boolean agreeTerms;
}
