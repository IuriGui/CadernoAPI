package org.ufsm.cadernocampoapi.mapper;


import org.mapstruct.Mapper;
import org.ufsm.cadernocampoapi.dto.AreaCultivoRequestDTO;
import org.ufsm.cadernocampoapi.dto.AreaCultivoResponseDTO;
import org.ufsm.cadernocampoapi.model.AreaCultivo;

@Mapper(componentModel = "spring")
public interface AreaCultivoMapper {


    AreaCultivoResponseDTO toDTO(AreaCultivo dto);

    AreaCultivo toEntity(AreaCultivoRequestDTO dto);


}
