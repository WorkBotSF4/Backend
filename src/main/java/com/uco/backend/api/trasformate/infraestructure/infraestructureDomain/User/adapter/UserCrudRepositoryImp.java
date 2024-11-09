package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.User.adapter;

import com.uco.backend.api.trasformate.application.DocumentService;
import com.uco.backend.api.trasformate.application.RoutineService;
import com.uco.backend.api.trasformate.domain.model.Document;
import com.uco.backend.api.trasformate.domain.model.User;
import com.uco.backend.api.trasformate.domain.port.IUserRepository;
import com.uco.backend.api.trasformate.infraestructure.dto.RoleDTO;
import com.uco.backend.api.trasformate.infraestructure.dto.UserRoutineDTO;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.User.mapper.UserMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.Objects;


@Repository
public class UserCrudRepositoryImp implements IUserRepository {

    private final IUserCrudRepository iUserCrudRepository;
    private final UserMapper userMapper;
    private final DocumentService documentService;
    private final RoutineService routineService;

    public UserCrudRepositoryImp(IUserCrudRepository iUserCrudRepository , UserMapper userMapper, DocumentService documentService, RoutineService routineService) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
        this.documentService = documentService;
        this.routineService = routineService;
    }

    @Override
    public User save(User user) {
        if (iUserCrudRepository.findBynameUser(user.getNameUser()).isPresent()) {
            throw new DataIntegrityViolationException("Username already exists");
        }else {
            user.setDocument(documentService.save(user.getDocument()));
            return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(user)));
        }
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.toUser(iUserCrudRepository.findBynameUser(username).orElseThrow(
                () -> new RuntimeException("Username not found")
        ));
    }

    @Override
    public User findById(int id) {
        return userMapper.toUser(iUserCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO EXISTE EN LA BASE DE DATOS EL ELEMENTO CON ID " + id)
        ));
    }

    @Override
    public Iterable<User> findAll() {
        return userMapper.toUsers(iUserCrudRepository.findAll());
    }

    @Override
    public void deleteById(int id) {
        iUserCrudRepository.deleteById(id);
    }

    @Override
    public void deleteByUsername(String username) {
        iUserCrudRepository.deleteBynameUser(username);
    }

    @Override
    public User updateUserRole(RoleDTO role) {
        User userdB = findById(role.id());
        userdB.setUserType(role.userType());
        return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(userdB)));
    }

    @Override
    public User updateUserRoutine(UserRoutineDTO user) {
        User userdB = findById(user.user());
        userdB.setRoutine(routineService.findById(user.routine()));
        return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(userdB)));
    }
}
