package org.ufsm.cadernocampoapi.dto;

import org.ufsm.cadernocampoapi.model.TipoLocalEnum;


//Vou precisar adicionar as areas de cultivo depois
public record LocalResponseDTO(
        Long id,
        String nome,
        TipoLocalEnum tipo,
        Double areaEmMetros,
        boolean quebraVento,
        boolean areaSensivel,
        String observacoes
) {
}
