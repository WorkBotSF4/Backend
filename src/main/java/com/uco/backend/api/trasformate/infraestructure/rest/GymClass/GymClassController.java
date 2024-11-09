package com.uco.backend.api.trasformate.infraestructure.rest.GymClass;

import com.uco.backend.api.trasformate.application.GYMClassService;
import com.uco.backend.api.trasformate.domain.model.GYMClass;
import com.uco.backend.api.trasformate.infraestructure.dto.AttendeesDTO;
import com.uco.backend.api.trasformate.infraestructure.dto.GYMClassDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/class")
public class GymClassController {
    private final GYMClassService gymClassService;
    public GymClassController(final GYMClassService gymClassService) {
        this.gymClassService = gymClassService;
    }
    @PostMapping("/crear")
    public GYMClass crearGymClass(@RequestBody GYMClassDTO gymClassDTO) {
        return gymClassService.save(gymClassDTO);
    }

    @GetMapping("/all")
    public Iterable<GYMClass> getAllGymClasses() {
        return gymClassService.findAll();
    }

    @PostMapping("/asis")
    public GYMClass attendees(@RequestBody AttendeesDTO attendeesDTO) {
        return gymClassService.attendees(attendeesDTO);
    }

}
