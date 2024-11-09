package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Area.mapper;

import com.uco.backend.api.trasformate.domain.model.Area;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Area.AreaEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IAreaMapper {

    @Mappings(
            {
                    @Mapping(source = "id" , target = "id"),
                    @Mapping(source = "name" , target = "name"),
                    @Mapping(source = "descriptionMaquinas" , target = "descriptionMaquinas")
            }
    )
    Area toArea(AreaEntity areaEntity);
    Iterable<Area> toAreas(Iterable<AreaEntity> areaEntities);

    @InheritInverseConfiguration
    AreaEntity toAreaEntity(Area area);
    Iterable<AreaEntity> toAreasEntities(Iterable<Area> areas);
}
