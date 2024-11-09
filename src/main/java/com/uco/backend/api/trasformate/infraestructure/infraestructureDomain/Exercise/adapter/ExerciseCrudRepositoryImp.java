package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Exercise.adapter;

import com.uco.backend.api.trasformate.domain.model.Exercise;
import com.uco.backend.api.trasformate.domain.port.IExerciseRepository;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Exercise.mapper.IExerciseMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ExerciseCrudRepositoryImp implements IExerciseRepository {
    private final IExerciseCrudRepository exerciseCrudRepository;
    private final IExerciseMapper exerciseMapper;

    public ExerciseCrudRepositoryImp(IExerciseCrudRepository exerciseCrudRepository, IExerciseMapper exerciseMapper) {
        this.exerciseCrudRepository = exerciseCrudRepository;
        this.exerciseMapper = exerciseMapper;
    }

    @Override
    public Exercise save(Exercise exercise) {
        return exerciseMapper.toExercise(exerciseCrudRepository.save(exerciseMapper.toExerciseEntity(exercise)));
    }

    @Override
    public Iterable<Exercise> findAll() {
        return exerciseMapper.toExercises(exerciseCrudRepository.findAll());
    }

    @Override
    public Exercise findById(int id) {
        return exerciseMapper.toExercise(exerciseCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO EXISTE EN LA BASE DE DATOS EL ELEMENTO CON ID " + id)
        ));
    }

    @Override
    public void deleteById(int id) {
        exerciseCrudRepository.deleteById(id);
    }

    @Override
    public Exercise updateExercise(Exercise exercise) {
        return exerciseMapper.toExercise(exerciseCrudRepository.save(exerciseMapper.toExerciseEntity(exercise)));
    }
}
