package com.helmes.sectors.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity(name = "Sector")
@AllArgsConstructor
@NoArgsConstructor
public class Sector {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
    private List<User> userList;
}
