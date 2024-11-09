package com.uco.backend.api.trasformate.infraestructure.dto;

import java.util.List;

public record GYMClassDTO(
        String nameClass,
        Integer area,
        String description,
        Integer teacher,
        List<Integer> exercises,
        String timeDate
        ) {
}
