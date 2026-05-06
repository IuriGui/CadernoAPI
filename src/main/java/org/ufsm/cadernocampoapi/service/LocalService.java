package org.ufsm.cadernocampoapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ufsm.cadernocampoapi.dto.LocalRequestDTO;
import org.ufsm.cadernocampoapi.dto.LocalResponseDTO;
import org.ufsm.cadernocampoapi.mapper.LocalMapper;
import org.ufsm.cadernocampoapi.model.Local;
import org.ufsm.cadernocampoapi.model.Propriedade;
import org.ufsm.cadernocampoapi.repositories.LocalRepository;
import org.ufsm.cadernocampoapi.repositories.ProdutorRepository;
import org.ufsm.cadernocampoapi.repositories.PropriedadeRepository;

@Service
@AllArgsConstructor

public class LocalService {

    private final LocalRepository localRepository;
    private final PropriedadeRepository propriedadeRepository;
    private final LocalMapper localMapper;


    public LocalResponseDTO criarLocal(LocalRequestDTO dto, Long propriedadeId){

        Propriedade propriedade = propriedadeRepository.findById(propriedadeId)
                .orElseThrow(() -> new EntityNotFoundException("Propriedade não encontrada"));

        Local local = localMapper.toEntity(dto);


        local.setPropriedade(propriedade);


        Local localSalvo = localRepository.save(local);

        return localMapper.toDto(localSalvo);
    }

}
