package org.ufsm.cadernocampoapi.dto;

import org.ufsm.cadernocampoapi.model.UnidadeMedida;

import java.time.LocalDateTime;

public record AnotacaoResponseDTO(
        Long id,
        LocalDateTime dataCriacao,
        UnidadeMedida unidadeMedida,
        Double quantidade,
        String observacoes,
        Long atividadeId,
        Long insumoId,
        Long culturaId,
        Long areaCultivoId
) {
}