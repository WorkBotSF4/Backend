package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Routine.adapter;

import com.uco.backend.api.trasformate.application.ExerciseService;
import com.uco.backend.api.trasformate.domain.model.Exercise;
import com.uco.backend.api.trasformate.domain.model.Routine;
import com.uco.backend.api.trasformate.domain.port.IRoutineRepository;
import com.uco.backend.api.trasformate.infraestructure.dto.RoutineDTO;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Routine.mapper.IRoutineMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoutineCrudRepositoryImp implements IRoutineRepository {
    private final IRoutineCrudRepository routineCrudRepository;
    private final IRoutineMapper routineMapper;
    private final ExerciseService exerciseService;

    public RoutineCrudRepositoryImp(IRoutineCrudRepository routineCrudRepository, IRoutineMapper routineMapper, ExerciseService exerciseService) {
        this.routineCrudRepository = routineCrudRepository;
        this.routineMapper = routineMapper;
        this.exerciseService = exerciseService;
    }


    @Override
    public Routine save(RoutineDTO routineDTO) {
        List<Exercise> exercisesResp = new ArrayList<>();
        Routine routine = new Routine();
        routine.setName(routineDTO.name());
        routine.setRemarks(routineDTO.remarks());
        for (int i = 0; i < routineDTO.exercises().size(); i++) {
            exercisesResp.add(exerciseService.findById(routineDTO.exercises().get(i)));
        }
        routine.setExercises(exercisesResp);
        return routineMapper.toRoutine(routineCrudRepository.save(routineMapper.toRoutineEntity(routine)));
    }

    @Override
    public Routine findById(int id) {
        return routineMapper.toRoutine(routineCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO EXISTE EN LA BASE DE DATOS EL ELEMENTO CON ID " + id)
        ));
    }

    @Override
    public Routine findByName(String name) {
        return routineMapper.toRoutine(routineCrudRepository.findByName(name));
    }

    @Override
    public Iterable<Routine> findAll() {
        return routineMapper.toRoutines(routineCrudRepository.findAll());
    }

    @Override
    public void deleteById(int id) {
        routineCrudRepository.deleteById(id);
    }

    @Override
    public Routine updateRoutine(Routine routine) {
        return routineMapper.toRoutine(routineCrudRepository.save(routineMapper.toRoutineEntity(routine)));
    }
}
