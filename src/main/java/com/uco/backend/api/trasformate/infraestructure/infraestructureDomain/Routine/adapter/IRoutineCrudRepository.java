package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Routine.adapter;

import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Routine.RoutineEntity;
import org.springframework.data.repository.CrudRepository;

public interface IRoutineCrudRepository extends CrudRepository<RoutineEntity, Integer> {
    RoutineEntity findByName(String name);
}
