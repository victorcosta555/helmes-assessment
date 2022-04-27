package com.helmes.sectors.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean agreeTerms;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Sector sector;
}
