package com.uco.backend.api.trasformate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Routine {
    private int id;
    private String name;
    private String remarks;
    private List<Exercise> exercises;

}
