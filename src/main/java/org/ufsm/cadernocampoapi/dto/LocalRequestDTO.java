package org.ufsm.cadernocampoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.ufsm.cadernocampoapi.model.TipoLocalEnum;

public record LocalRequestDTO(
        @NotBlank String nome,
        @NotNull TipoLocalEnum tipo,
        @NotNull Double areaEmMetros,
        @NotNull boolean quebraVento,
        @NotNull boolean areaSensivel,
        String observacoes
) {
}
