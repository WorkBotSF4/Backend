package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Exercise.adapter;

import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Exercise.ExerciseEntity;
import org.springframework.data.repository.CrudRepository;

public interface IExerciseCrudRepository extends CrudRepository<ExerciseEntity, Integer> {
}
