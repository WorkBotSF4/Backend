package com.uco.backend.api.trasformate.infraestructure.rest.Routine;

import com.uco.backend.api.trasformate.application.RoutineService;
import com.uco.backend.api.trasformate.domain.model.Routine;
import com.uco.backend.api.trasformate.infraestructure.dto.RoutineDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/routines")
public class RoutineController {
    private final RoutineService routineService;
    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @PostMapping("/crear")
    public Routine  createRoutine(@RequestBody RoutineDTO routineDto) {
        return routineService.save(routineDto);
    }

    @GetMapping("/get/{id}")
    public Routine findById(@PathVariable int id) {
        return routineService.findById(id);
    }

    @GetMapping("/all")
    public Iterable<Routine> findAll() {
        return routineService.findAll();
    }



}
