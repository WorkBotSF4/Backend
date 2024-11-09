package com.uco.backend.api.trasformate.infraestructure.dto;

import java.util.List;

public record RoutineDTO(String name , String remarks , List<Integer> exercises) {
}
