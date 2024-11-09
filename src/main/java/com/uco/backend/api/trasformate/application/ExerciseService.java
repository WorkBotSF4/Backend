package com.uco.backend.api.trasformate.application;

import com.uco.backend.api.trasformate.domain.model.Exercise;
import com.uco.backend.api.trasformate.domain.port.IExerciseRepository;

public class ExerciseService {
    private final IExerciseRepository exerciseRepository;
    public ExerciseService(IExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
    public Iterable<Exercise> findAll() {
        return exerciseRepository.findAll();
    }
    public Exercise findById(int id) {
        return exerciseRepository.findById(id);
    }
    public void deleteById(int id) {
        exerciseRepository.deleteById(id);
    }
    public Exercise update(Exercise exercise) {
        return exerciseRepository.updateExercise(exercise);
    }

}
