package com.uco.backend.api.trasformate.domain.port;

import com.uco.backend.api.trasformate.domain.model.User;
import com.uco.backend.api.trasformate.infraestructure.dto.RoleDTO;
import com.uco.backend.api.trasformate.infraestructure.dto.UserRoutineDTO;

public interface IUserRepository {
    User save(User user);
    User findByUsername(String username);
    User findById(int id);
    Iterable<User> findAll();
    void deleteById(int id);
    void deleteByUsername(String username);
    User updateUserRole(RoleDTO user);
    User updateUserRoutine(UserRoutineDTO user);
}
