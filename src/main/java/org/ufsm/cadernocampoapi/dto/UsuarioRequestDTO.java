package org.ufsm.cadernocampoapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioRequestDTO {
    private String email;
    private String password;
    private String nome;

    private MecanismoControleDTO mecanismo;
    private List<ProgramaComercializacaoDTO> programaComercializacao;
}