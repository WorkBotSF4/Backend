package com.uco.backend.api.trasformate.domain.port;

import com.uco.backend.api.trasformate.domain.model.Exercise;

public interface IExerciseRepository {
    Exercise save(Exercise exercise);
    Iterable<Exercise> findAll();
    Exercise findById(int id);
    void deleteById(int id);
    Exercise updateExercise(Exercise exercise);

}