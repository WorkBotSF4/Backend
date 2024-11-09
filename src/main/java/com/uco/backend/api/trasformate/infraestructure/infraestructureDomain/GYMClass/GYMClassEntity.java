package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.GYMClass;

import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Area.AreaEntity;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Exercise.ExerciseEntity;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.User.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "GYMCLass")
@Data
@NoArgsConstructor
public class GYMClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nameClass;

    @ManyToOne(fetch = FetchType.LAZY)
    private AreaEntity area;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity teacher;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<ExerciseEntity> exercises;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<UserEntity> attendees;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String timeDate;
}
