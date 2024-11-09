package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.User.adapter;

import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.User.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserCrudRepository  extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findBynameUser(String username);
    void deleteBynameUser(String username);
}
