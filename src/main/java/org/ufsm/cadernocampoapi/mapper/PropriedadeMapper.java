package org.ufsm.cadernocampoapi.mapper;


import org.mapstruct.Mapper;
import org.ufsm.cadernocampoapi.dto.PropriedadeRequestDTO;
import org.ufsm.cadernocampoapi.dto.PropriedadeResponseDTO;
import org.ufsm.cadernocampoapi.model.Propriedade;

@Mapper(componentModel = "spring")
public interface PropriedadeMapper {


    Propriedade toEntity(PropriedadeRequestDTO dto);

    PropriedadeResponseDTO toDto(Propriedade propriedade);


}
