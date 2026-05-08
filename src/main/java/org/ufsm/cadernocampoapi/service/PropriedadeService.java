package org.ufsm.cadernocampoapi.service;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;
import org.ufsm.cadernocampoapi.dto.CompartilharAcessoDTO;
import org.ufsm.cadernocampoapi.dto.PropriedadeRequestDTO;
import org.ufsm.cadernocampoapi.dto.PropriedadeResponseDTO;
import org.ufsm.cadernocampoapi.mapper.PropriedadeMapper;
import org.ufsm.cadernocampoapi.model.NivelAcesso;
import org.ufsm.cadernocampoapi.model.Produtor;
import org.ufsm.cadernocampoapi.model.ProdutorPropriedade;
import org.ufsm.cadernocampoapi.model.Propriedade;
import org.ufsm.cadernocampoapi.repositories.ProdutorPropriedadeRepository;
import org.ufsm.cadernocampoapi.repositories.ProdutorRepository;
import org.ufsm.cadernocampoapi.repositories.PropriedadeRepository;
import org.ufsm.cadernocampoapi.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropriedadeService {

    private final ProdutorRepository produtorRepository;
    private final PropriedadeRepository propriedadeRepository;
    private final PropriedadeMapper propriedadeMapper;
    private final UsuarioRepository usuarioRepository;
    private final ProdutorPropriedadeRepository produtorPropriedadeRepository;


    @Transactional
    public PropriedadeResponseDTO criarPropriedade(PropriedadeRequestDTO propriedadeRequestDTO) {

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


        // Fixo no momento de teste
        Produtor produtor = produtorRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Produtor não encontrado"));

        ProdutorPropriedade relacao = new ProdutorPropriedade();
        relacao.setPropriedade(prop);
        relacao.setProdutor(produtor);
        relacao.setPapel(NivelAcesso.PROPRIETARIO);

        prop.setProdutores(List.of(relacao));

        return propriedadeMapper
                .toDto(propriedadeRepository.save(prop));
    }


    public void compartilharAcesso(Long propriedadeId, CompartilharAcessoDTO dto){

/*
            1. Procura o produtor pelo email
            2. Procura a propriedade
*/

        // Achar produtor
        Optional<Produtor> produtor = produtorRepository.findByUsuarioEmail(dto.emailUsuario());
        if(produtor.isEmpty()) {
            throw new RuntimeException("Produtor não encontrado");
        }
        Optional<Propriedade> propriedade = propriedadeRepository.findById(propriedadeId);
        if(propriedade.isEmpty()){
            throw new RuntimeException();
        }
        ProdutorPropriedade relacionamento = new ProdutorPropriedade();
        relacionamento.setProdutor(produtor.get());
        relacionamento.setPropriedade(propriedade.get());
        relacionamento.setPapel(NivelAcesso.COLABORADOR);

        produtorPropriedadeRepository.save(relacionamento);


    }

    
    //Editar
    //Deletar

}
