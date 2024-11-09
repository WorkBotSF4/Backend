package com.uco.backend.api.trasformate.domain.port;

import com.uco.backend.api.trasformate.domain.model.GYMClass;
import com.uco.backend.api.trasformate.infraestructure.dto.AttendeesDTO;
import com.uco.backend.api.trasformate.infraestructure.dto.GYMClassDTO;

public interface IGYMClassRepository {
    GYMClass save(GYMClassDTO gymClassDTO);
    GYMClass findById(int id);
    GYMClass findByName(String name);
    Iterable<GYMClass> findAll();
    GYMClass updateGYMClass(GYMClass gymClass);
    void deleteById(int id);
    GYMClass findBytimeDate(String date);
    GYMClass attendees (AttendeesDTO attendeesDTO);
}

