package com.uco.backend.api.trasformate.application;

import com.uco.backend.api.trasformate.domain.model.User;
import com.uco.backend.api.trasformate.domain.port.IUserRepository;
import com.uco.backend.api.trasformate.infraestructure.dto.RoleDTO;
import com.uco.backend.api.trasformate.infraestructure.dto.UserRoutineDTO;

public class UserService {
   private final IUserRepository userRepository;
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User findById(int id) {
        return userRepository.findById(id);
    }
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
    public User update(RoleDTO user) {
        return userRepository.updateUserRole(user);
    }
    public User UpdateRutine(UserRoutineDTO userRoutineDTO) {
        return userRepository.updateUserRoutine(userRoutineDTO);
    }

}
