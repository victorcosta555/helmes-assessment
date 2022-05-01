package com.helmes.sectors.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectorDTO {

    @NotNull(message = "id is mandatory")
    private Long id;

    private String name;
}
