package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.GYMClass.adapter;

import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.GYMClass.GYMClassEntity;
import org.springframework.data.repository.CrudRepository;

public interface IGYMClassCrudRepository extends CrudRepository<GYMClassEntity, Integer> {

    GYMClassEntity findBynameClass(String name);
    GYMClassEntity findBytimeDate(String timeDate);
}
