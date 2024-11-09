package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Routine;

import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Exercise.ExerciseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "Rountines")
@Data
@NoArgsConstructor
public class RoutineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
    private String remarks;

    @ManyToMany
    private List<ExerciseEntity> exercises;
}
