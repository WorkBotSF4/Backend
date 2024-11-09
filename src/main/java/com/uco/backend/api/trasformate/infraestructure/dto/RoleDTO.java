package com.uco.backend.api.trasformate.infraestructure.dto;

import com.uco.backend.api.trasformate.domain.model.UserType;

public record RoleDTO(int id, UserType userType) {
}
