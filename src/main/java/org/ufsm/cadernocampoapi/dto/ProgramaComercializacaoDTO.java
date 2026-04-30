package org.ufsm.cadernocampoapi.dto;

import lombok.Data;
import org.ufsm.cadernocampoapi.model.ProgramaComercializacaoEnum;

@Data
public class ProgramaComercializacaoDTO {
    private ProgramaComercializacaoEnum tipo;
    private String valor;
}
