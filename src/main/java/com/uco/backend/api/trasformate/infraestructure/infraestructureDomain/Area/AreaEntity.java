package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Area;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Areas")
@Data
@NoArgsConstructor
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String descriptionMaquinas;
}
