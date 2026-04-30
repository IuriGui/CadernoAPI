package org.ufsm.cadernocampoapi.dto;

import lombok.Data;
import org.ufsm.cadernocampoapi.model.MecanismoControleEnum;

@Data
public class MecanismoControleDTO {
    private MecanismoControleEnum tipo;
    private String valor;
}
