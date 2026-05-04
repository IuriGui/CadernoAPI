package org.ufsm.cadernocampoapi.dto;

import jakarta.validation.constraints.NotBlank;

public record AreaCultivoRequestDTO(
       @NotBlank String nome
) {
}
