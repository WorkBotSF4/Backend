package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.User;


import com.uco.backend.api.trasformate.domain.model.UserType;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Document.DocumentEntity;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Routine.RoutineEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;

    @Column(unique = true, nullable = false)
    private String nameUser;
    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private DocumentEntity document;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private RoutineEntity routine;

    @CreationTimestamp
    private LocalDateTime created;
}
