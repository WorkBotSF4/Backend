package com.uco.backend.api.trasformate.application;

import com.uco.backend.api.trasformate.domain.model.Area;
import com.uco.backend.api.trasformate.domain.port.IAreaRepository;

public class AreaService {
   private final IAreaRepository areaRepository;

    public AreaService(IAreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
    public Area save(Area area) {
        return areaRepository.save(area);
    }
    public Iterable<Area> findAll() {
        return areaRepository.findAll();
    }
    public Area findById(int id) {
        return areaRepository.findById(id);
    }
    public Area findByName(String name) {
        return areaRepository.findByName(name);
    }
    public void deleteById(int area) {
        areaRepository.deleteById(area);
    }
    public Area update(int id , Area area) {
        return areaRepository.updateArea(id ,area);
    }
}
