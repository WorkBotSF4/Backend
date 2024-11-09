package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Exercise.mapper;

import com.uco.backend.api.trasformate.domain.model.Exercise;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Exercise.ExerciseEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IExerciseMapper {

    @Mappings(
            {
                    @Mapping(source = "id" , target = "id"),
                    @Mapping(source = "name" , target = "name"),
                    @Mapping(source = "description" , target = "description"),
                    @Mapping(source = "serie" , target = "serie")
            }
    )
    Exercise toExercise(ExerciseEntity exerciseEntity);
    Iterable<Exercise> toExercises(Iterable<ExerciseEntity> exerciseEntityIterable);

    @InheritInverseConfiguration
    ExerciseEntity toExerciseEntity(Exercise exercise);

    Iterable<ExerciseEntity> toExerciseEntities(Iterable<Exercise> exercises);

}
