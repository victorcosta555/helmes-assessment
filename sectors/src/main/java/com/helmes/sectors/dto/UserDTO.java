package com.helmes.sectors.dto;

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
    public Long sectorValue;

    @NotNull
    public Boolean agreeTerms;
}
