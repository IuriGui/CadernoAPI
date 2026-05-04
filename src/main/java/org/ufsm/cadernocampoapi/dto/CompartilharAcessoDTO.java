package org.ufsm.cadernocampoapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.ufsm.cadernocampoapi.model.NivelAcesso;

public record CompartilharAcessoDTO(
        @Email @NotBlank
        String emailUsuario,
        @NotNull
        NivelAcesso nivel) {
}
