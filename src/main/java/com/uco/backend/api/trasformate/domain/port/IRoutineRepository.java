package com.uco.backend.api.trasformate.domain.port;

import com.uco.backend.api.trasformate.domain.model.Routine;
import com.uco.backend.api.trasformate.infraestructure.dto.RoutineDTO;

public interface IRoutineRepository {
    Routine save(RoutineDTO routineDTO);
    Routine findById(int id);
    Routine findByName(String name);
    Iterable<Routine> findAll();
    void deleteById(int id);
    Routine updateRoutine(Routine routine);

}
