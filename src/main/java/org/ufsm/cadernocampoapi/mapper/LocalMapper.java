package org.ufsm.cadernocampoapi.mapper;


import org.mapstruct.Mapper;
import org.ufsm.cadernocampoapi.dto.LocalRequestDTO;
import org.ufsm.cadernocampoapi.dto.LocalResponseDTO;
import org.ufsm.cadernocampoapi.model.Local;

@Mapper(componentModel = "spring")
public interface LocalMapper {

    Local toEntity(LocalRequestDTO dto);

    LocalResponseDTO toDto(Local local);
}
