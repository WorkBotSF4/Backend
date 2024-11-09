package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.GYMClass.adapter;

import com.uco.backend.api.trasformate.application.AreaService;
import com.uco.backend.api.trasformate.application.ExerciseService;
import com.uco.backend.api.trasformate.application.UserService;
import com.uco.backend.api.trasformate.domain.model.Exercise;
import com.uco.backend.api.trasformate.domain.model.GYMClass;
import com.uco.backend.api.trasformate.domain.port.IGYMClassRepository;
import com.uco.backend.api.trasformate.infraestructure.dto.AttendeesDTO;
import com.uco.backend.api.trasformate.infraestructure.dto.GYMClassDTO;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.GYMClass.mapper.IGYMClassMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GYMClassCrudRepositoryImp implements IGYMClassRepository {
    private final IGYMClassCrudRepository crudRepository;
    private final UserService userService;
    private final ExerciseService exerciseService;
    private final AreaService areaService;
    private final IGYMClassMapper mapper;

    public GYMClassCrudRepositoryImp(IGYMClassCrudRepository crudRepository, UserService userService, ExerciseService exerciseService, AreaService areaService, IGYMClassMapper mapper) {
        this.crudRepository = crudRepository;
        this.userService = userService;
        this.exerciseService = exerciseService;
        this.areaService = areaService;
        this.mapper = mapper;
    }

    @Override
    public GYMClass save(GYMClassDTO gymClassDTO) {
        GYMClass gymClass = new GYMClass();
        gymClass.setNameClass(gymClassDTO.nameClass());
        gymClass.setArea(areaService.findById(gymClassDTO.area()));
        gymClass.setDescription(gymClassDTO.description());
        gymClass.setTeacher(userService.findById(gymClassDTO.teacher()));
        List<Exercise> exercisesResp = new ArrayList<>();
        for (int i = 0; i < gymClassDTO.exercises().size(); i++) {
            exercisesResp.add(exerciseService.findById(gymClassDTO.exercises().get(i)));
        }
        gymClass.setExercises(exercisesResp);
        gymClass.setTimeDate(gymClassDTO.timeDate());

        return mapper.toGymClass(crudRepository.save(mapper.toGymClassEntity(gymClass)));
    }

    @Override
    public GYMClass findById(int id) {
        return mapper.toGymClass(crudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO EXISTE EN LA BASE DE DATOS EL ELEMENTO CON ID " + id)
        ));
    }

    @Override
    public GYMClass findByName(String name) {
        return mapper.toGymClass(crudRepository.findBynameClass(name));
    }

    @Override
    public Iterable<GYMClass> findAll() {
        return mapper.toGymClassList(crudRepository.findAll());
    }

    @Override
    public GYMClass updateGYMClass(GYMClass gymClass) {
        return mapper.toGymClass(crudRepository.save(mapper.toGymClassEntity(gymClass)));
    }

    @Override
    public void deleteById(int id) {
        crudRepository.deleteById(id);
    }

    @Override
    public GYMClass findBytimeDate(String date) {
        return mapper.toGymClass(crudRepository.findBytimeDate(date));
    }

    @Override
    public GYMClass attendees(AttendeesDTO attendeesDTO) {
        GYMClass gymClass = findById(attendeesDTO.classId());
        gymClass.getAttendees().add(userService.findById(attendeesDTO.user()));
        return mapper.toGymClass(crudRepository.save(mapper.toGymClassEntity(gymClass)));
    }
}
