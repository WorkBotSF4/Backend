package com.uco.backend.api.trasformate.infraestructure.rest.Exercise;

import com.uco.backend.api.trasformate.application.ExerciseService;
import com.uco.backend.api.trasformate.domain.model.Exercise;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/crear")
    public Exercise crear(@RequestBody Exercise exercise) {
        return exerciseService.save(exercise);
    }

    @GetMapping("/get/{id}")
    public Exercise findById(@PathVariable int id) {
        return exerciseService.findById(id);
    }

    @GetMapping("/all")
    public Iterable<Exercise> findAll() {
        return exerciseService.findAll();
    }

}
