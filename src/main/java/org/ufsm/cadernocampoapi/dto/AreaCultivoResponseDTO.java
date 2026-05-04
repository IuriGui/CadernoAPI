package org.ufsm.cadernocampoapi.dto;

public record AreaCultivoResponseDTO(
        Long id,
        String nome,
        LocalResponseDTO local
) {
}
