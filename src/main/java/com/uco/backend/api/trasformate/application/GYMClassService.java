package com.uco.backend.api.trasformate.application;

import com.uco.backend.api.trasformate.domain.model.GYMClass;
import com.uco.backend.api.trasformate.domain.port.IGYMClassRepository;
import com.uco.backend.api.trasformate.infraestructure.dto.AttendeesDTO;
import com.uco.backend.api.trasformate.infraestructure.dto.GYMClassDTO;

public class GYMClassService {
    private final IGYMClassRepository repository;
    public GYMClassService(IGYMClassRepository repository) {
        this.repository = repository;
    }
    public GYMClass save(GYMClassDTO gymClassDTO) {
        return repository.save(gymClassDTO);
    }
    public GYMClass findById(int id) {
        return repository.findById(id);
    }
    public GYMClass findByName(String name) {
        return repository.findByName(name);
    }
    public Iterable<GYMClass> findAll() {
        return repository.findAll();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
    public GYMClass findBytimeDate(String date) {
        return repository.findBytimeDate(date);
    }
    public GYMClass update(GYMClass gymClass) {
        return repository.updateGYMClass(gymClass);
    }
    public GYMClass attendees(AttendeesDTO attendeesDTO) {
        return repository.attendees(attendeesDTO);
    }
}
