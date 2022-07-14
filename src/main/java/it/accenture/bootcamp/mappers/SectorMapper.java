package it.accenture.bootcamp.mappers;

import it.accenture.bootcamp.dtos.SectorDTO;
import it.accenture.bootcamp.models.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectorMapper {
    SectorMapper INSTANCE = Mappers.getMapper(SectorMapper.class);

    SectorDTO toSectorDto(Sector sector);

    Sector toSector(SectorDTO sectorDto);

}
