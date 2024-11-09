package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Area.adapter;

import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Area.AreaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IAreaCrudRapository extends CrudRepository<AreaEntity, Integer> {
    AreaEntity findByname(String name);
}
