package com.uco.backend.api.trasformate.application;

import com.uco.backend.api.trasformate.domain.model.User;
import com.uco.backend.api.trasformate.domain.port.IUserRepository;

public class RegistrationService {
    private final IUserRepository userRepository;

    public RegistrationService(IUserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
