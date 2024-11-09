package com.uco.backend.api.trasformate.infraestructure.rest.Area;

import com.uco.backend.api.trasformate.application.AreaService;
import com.uco.backend.api.trasformate.domain.model.Area;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/areas")
public class AreaController {
    private final AreaService areaService;
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/crear")
    public Area createArea(@RequestBody Area area) {
        return areaService.save(area);
    }

    @PostMapping("/upd/{id}")
    public Area updateArea(@PathVariable int id, @RequestBody Area area) {
        return areaService.update(id , area);
    }

    @GetMapping("/all")
    public Iterable<Area> getAllAreas() {
        return areaService.findAll();
    }

    @GetMapping("/get/{id}")
    public Area findById(@PathVariable int id) {
        return areaService.findById(id);
    }

    @DeleteMapping("/del/{id}")
    public void deleteArea(@PathVariable int id) {
        areaService.deleteById(id);
    }
}
