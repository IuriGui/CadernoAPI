package org.ufsm.cadernocampoapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.ufsm.cadernocampoapi.dto.MecanismoControleDTO;
import org.ufsm.cadernocampoapi.dto.ProgramaComercializacaoDTO;
import org.ufsm.cadernocampoapi.dto.UsuarioRequestDTO;
import org.ufsm.cadernocampoapi.dto.UsuarioResponseDTO;
import org.ufsm.cadernocampoapi.model.MecanismoControle;
import org.ufsm.cadernocampoapi.model.ProgramaComercializacao;
import org.ufsm.cadernocampoapi.model.Usuario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    // Usuario
    @Mapping(source = "produtor.nome", target = "nomeProdutor")
    @Mapping(source = "produtor.mecanismoControle", target = "mecanismoControle")
    @Mapping(source = "produtor.programaComercializacao", target = "programaComercializacao")
    UsuarioResponseDTO toDTO(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produtor", ignore = true)
    Usuario toEntity(UsuarioRequestDTO dto);

    // MecanismoControle
    MecanismoControleDTO toDTO(MecanismoControle mecanismoControle);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produtor", ignore = true)
    MecanismoControle toEntity(MecanismoControleDTO dto);

    // ProgramaComercializacao
    ProgramaComercializacaoDTO toDTO(ProgramaComercializacao programaComercializacao);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produtor", ignore = true)
    ProgramaComercializacao toEntity(ProgramaComercializacaoDTO dto);


    List<ProgramaComercializacaoDTO> toDTOList(List<ProgramaComercializacao> programaComercializacao);

    List<ProgramaComercializacao> toEntityList(List<ProgramaComercializacaoDTO> dtos);

}