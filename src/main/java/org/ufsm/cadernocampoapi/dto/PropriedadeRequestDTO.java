package org.ufsm.cadernocampoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
public class PropriedadeRequestDTO {

    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    @NotBlank(message = "O CEP deve ser informado")
    private String cep;

    @NotBlank(message = "A cidade deve ser informada")
    private String cidade;

    @NotBlank(message = "O estado deve ser informado")
    @Size(min = 2, max = 2, message = "Use as siglas dos estados")
    private String estado;

    @NotBlank(message = "A área total da propriedade deve ser informada")
    private Double areaTotal;

    @NotBlank(message = "Você deve informar a sua área própria")
    private Double areaPropria;

    private Double areaArrendada;

    private Double areaProducaoVegetal;
}
