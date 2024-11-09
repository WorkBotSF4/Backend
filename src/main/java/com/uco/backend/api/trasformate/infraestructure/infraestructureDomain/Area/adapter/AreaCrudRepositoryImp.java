package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Area.adapter;

import com.uco.backend.api.trasformate.application.AreaService;
import com.uco.backend.api.trasformate.domain.model.Area;
import com.uco.backend.api.trasformate.domain.port.IAreaRepository;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Area.mapper.IAreaMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AreaCrudRepositoryImp implements IAreaRepository {
    private final IAreaCrudRapository areaCrudRapository;
    private final IAreaMapper areaMapper;
    public AreaCrudRepositoryImp(IAreaCrudRapository areaCrudRapository, IAreaMapper areaMapper) {
        this.areaCrudRapository = areaCrudRapository;
        this.areaMapper = areaMapper;
    }

    @Override
    public Area save(Area area) {
        return areaMapper.toArea(areaCrudRapository.save(areaMapper.toAreaEntity(area)));
    }

    @Override
    public Area findById(int id) {
        return areaMapper.toArea(areaCrudRapository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO EXISTE EN LA BASE DE DATOS EL ELEMENTO CON ID " + id)
        ));
    }

    @Override
    public Area findByName(String name) {
        return areaMapper.toArea(areaCrudRapository.findByname(name));
    }

    @Override
    public void deleteById(int id) {
        areaCrudRapository.deleteById(id);
    }

    @Override
    public Area updateArea(int id,  Area area) {
        area.setId(id);
        return areaMapper.toArea(areaCrudRapository.save(areaMapper.toAreaEntity(area)));
    }

    @Override
    public Iterable<Area> findAll() {
        return areaMapper.toAreas(areaCrudRapository.findAll());
    }
}
