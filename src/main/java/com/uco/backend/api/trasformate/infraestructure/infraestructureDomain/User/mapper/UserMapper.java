package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.User.mapper;


import com.uco.backend.api.trasformate.domain.model.User;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.User.UserEntity;
import org.mapstruct.*;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING )
public interface UserMapper {

    @Mappings(
            {
                    @Mapping(source = "id" , target = "id"),
                    @Mapping(source = "name" , target = "name"),
                    @Mapping(source = "lastname" , target = "lastname"),
                    @Mapping(source = "nameUser" , target = "nameUser"),
                    @Mapping(source = "password" , target = "password"),
                    @Mapping(source = "document" , target = "document"),
                    @Mapping(source = "userType" , target = "userType"),
                    @Mapping(source = "address" , target = "address"),
                    @Mapping(source = "phone" , target = "phone"),
                    @Mapping(source = "routine" , target = "routine"),
                    @Mapping(source = "created" , target = "created")
            }
    )
    User toUser(UserEntity userEntity);


    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);

    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    Iterable<UserEntity> toUsersEtities(Iterable<User> users);

}
