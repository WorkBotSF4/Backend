package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Document;

import com.uco.backend.api.trasformate.domain.model.DocumentType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Documents")
@Data
@NoArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;
}
