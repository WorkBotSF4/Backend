package com.uco.backend.api.trasformate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    private int id;
    private String name;
    private String descriptionMaquinas;
}
