package org.ufsm.cadernocampoapi.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.ufsm.cadernocampoapi.dto.AnotacaoRequestDTO;
import org.ufsm.cadernocampoapi.dto.AnotacaoResponseDTO;
import org.ufsm.cadernocampoapi.model.Anotacao;

@Mapper(componentModel = "spring")
public interface AnotacaoMapper {

    @Mapping(target = "atividade", ignore = true)
    @Mapping(target = "insumo", ignore = true)
    @Mapping(target = "areaCultivo", ignore = true)
    @Mapping(target = "cultura", ignore = true)
    @Mapping(target = "observacoes", source = "observacoes")
    Anotacao toEntity(AnotacaoRequestDTO dto);

    @Mapping(source = "atividade.id", target = "atividadeId")
    @Mapping(source = "insumo.id", target = "insumoId")
    @Mapping(source = "cultura.id", target = "culturaId")
    @Mapping(source = "areaCultivo.id", target = "areaCultivoId")
    @Mapping(source = "observacoes", target = "observacoes")
    AnotacaoResponseDTO toDTO(Anotacao anotacao);
}
