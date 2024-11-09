package com.uco.backend.api.trasformate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    private int id;
    private String number;
    private DocumentType documentType;
}
