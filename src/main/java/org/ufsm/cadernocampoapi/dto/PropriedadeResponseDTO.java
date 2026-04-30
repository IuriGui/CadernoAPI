package org.ufsm.cadernocampoapi.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.ufsm.cadernocampoapi.model.Produtor;

@Data
public class PropriedadeResponseDTO {

    private String nome;

    private String cep;

    private String cidade;

    private String estado;

    private Double areaTotal;

    private Double areaPropria;

    private Double areaArrendada;

    private Double areaProducaoVegetal;


}
