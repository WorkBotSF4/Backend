package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.GYMClass.mapper;

import com.uco.backend.api.trasformate.domain.model.GYMClass;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.GYMClass.GYMClassEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IGYMClassMapper {

    @Mappings(
            {
                    @Mapping(source = "id" , target = "id"),
                    @Mapping(source = "nameClass" , target = "nameClass"),
                    @Mapping(source = "area" , target = "area"),
                    @Mapping(source = "description" , target = "description"),
                    @Mapping(source = "teacher" , target = "teacher"),
                    @Mapping(source = "exercises" , target = "exercises"),
                    @Mapping(source = "attendees" , target = "attendees"),
                    @Mapping(source = "createdAt" , target = "createdAt"),
                    @Mapping(source = "timeDate" , target = "timeDate")
            }
    )
    GYMClass toGymClass(GYMClassEntity gymClassEntity);
    Iterable<GYMClass> toGymClassList(Iterable<GYMClassEntity> gymClassEntities);

    @InheritInverseConfiguration
    GYMClassEntity toGymClassEntity(GYMClass gymClass);
    Iterable<GYMClassEntity> toGymClassEntityList(Iterable<GYMClass> gymClassEntities);

}
