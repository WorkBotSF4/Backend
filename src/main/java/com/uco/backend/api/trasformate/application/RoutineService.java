package com.uco.backend.api.trasformate.application;

import com.uco.backend.api.trasformate.domain.model.Routine;
import com.uco.backend.api.trasformate.domain.port.IRoutineRepository;
import com.uco.backend.api.trasformate.infraestructure.dto.RoutineDTO;

public class RoutineService {
    private final IRoutineRepository routineRepository;
    public RoutineService(IRoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }
    public Routine save(RoutineDTO routineDTO) {
        return routineRepository.save(routineDTO);
    }
    public Routine findById(int id) {
        return routineRepository.findById(id);
    }
    public Routine findByName(String name) {
        return routineRepository.findByName(name);
    }
    public Iterable<Routine> findAll() {
        return routineRepository.findAll();
    }
    public void deleteById(int id) {
        routineRepository.deleteById(id);
    }
    public Routine update(Routine routine) {
        return routineRepository.updateRoutine(routine);
    }
}
