package org.ufsm.cadernocampoapi.dto;


import lombok.Data;
import org.ufsm.cadernocampoapi.model.MecanismoControleEnum;
import org.ufsm.cadernocampoapi.model.ProgramaComercializacaoEnum;

import java.util.List;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String email;
    private String nomeProdutor;
    private MecanismoControleDTO mecanismoControle;
    private List<ProgramaComercializacaoDTO> programaComercializacao;
}
