package com.helmes.sectors.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private LocalDateTime localDateTime;
    private String message;
    private String details;
}
