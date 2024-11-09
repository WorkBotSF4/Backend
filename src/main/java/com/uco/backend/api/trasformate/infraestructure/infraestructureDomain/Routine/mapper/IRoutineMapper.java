package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Routine.mapper;


import com.uco.backend.api.trasformate.domain.model.Routine;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Routine.RoutineEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IRoutineMapper {

    @Mappings(
            {
                    @Mapping(source = "id" , target = "id"),
                    @Mapping(source = "name" , target = "name"),
                    @Mapping(source = "remarks" , target = "remarks"),
                    @Mapping(source = "exercises" , target = "exercises")
            }
    )
    Routine toRoutine(RoutineEntity routineEntity);
    Iterable<Routine> toRoutines(Iterable<RoutineEntity> routines);

    @InheritInverseConfiguration
    RoutineEntity toRoutineEntity(Routine routine);
    Iterable<RoutineEntity> toRoutineEntities(Iterable<Routine> routines);

}
