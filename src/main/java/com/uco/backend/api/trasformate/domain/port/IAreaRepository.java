package com.uco.backend.api.trasformate.domain.port;

import com.uco.backend.api.trasformate.domain.model.Area;

public interface IAreaRepository {
    Area findById(int id);
    Area findByName(String name);
    Area save(Area area);
    void deleteById(int id);
    Area updateArea(int id , Area area);
    Iterable<Area> findAll();
}

