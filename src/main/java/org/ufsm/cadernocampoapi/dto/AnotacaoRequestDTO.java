package org.ufsm.cadernocampoapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.ufsm.cadernocampoapi.model.UnidadeMedida;

import java.util.Date;


public record AnotacaoRequestDTO(
        @NotNull Date dataCriacao,
        @NotNull Long atividadeId,
        UnidadeMedida unidadeMedida,
        Double quantidade,
        Long insumoId,
        String observacoes
        ) {}
