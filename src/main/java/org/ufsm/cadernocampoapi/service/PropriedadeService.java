package org.ufsm.cadernocampoapi.service;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;
import org.ufsm.cadernocampoapi.dto.PropriedadeRequestDTO;
import org.ufsm.cadernocampoapi.model.Produtor;
import org.ufsm.cadernocampoapi.model.ProdutorPropriedade;
import org.ufsm.cadernocampoapi.model.Propriedade;
import org.ufsm.cadernocampoapi.repositories.ProdutorRepository;
import org.ufsm.cadernocampoapi.repositories.PropriedadeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PropriedadeService {

    private final ProdutorRepository produtorRepository;
    private final PropriedadeRepository propriedadeRepository;


    @Transactional
    public void criarPropriedade(PropriedadeRequestDTO propriedadeRequestDTO) {

        Propriedade prop = Propriedade.builder()
                .nome(propriedadeRequestDTO.getNome())
                .cep(propriedadeRequestDTO.getCep())
                .cidade(propriedadeRequestDTO.getCidade())
                .estado(propriedadeRequestDTO.getEstado())
                .areaTotal(propriedadeRequestDTO.getAreaTotal())
                .areaPropria(propriedadeRequestDTO.getAreaPropria())
                .areaArrendada(propriedadeRequestDTO.getAreaArrendada())
                .areaProducaoVegetal(propriedadeRequestDTO.getAreaProducaoVegetal())
                .build();

        Produtor produtor = produtorRepository.findById(5L)
                .orElseThrow(() -> new RuntimeException("Produtor não encontrado"));

        ProdutorPropriedade relacao = new ProdutorPropriedade();
        relacao.setPropriedade(prop);
        relacao.setProdutor(produtor);
        relacao.setPapel("PROPRIETARIO");
        prop.setProdutores(List.of(relacao));

        propriedadeRepository.save(prop);
    }




}
