package org.ufsm.cadernocampoapi.service;


import org.springframework.stereotype.Service;
import org.ufsm.cadernocampoapi.model.Propriedade;

@Service
public class PropriedadeService {

    private void criarPropriedade() {
        Propriedade prop = Propriedade.builder()
                .nome("Sítio do Pica-Pau")
                .cep("97000-000")
                .cidade("Santa Maria")
                .estado("RS")
                .areaTotal(50.0)
                .areaPropria(50.0)
                .build();
    }




}
