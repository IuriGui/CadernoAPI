package org.ufsm.cadernocampoapi.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ufsm.cadernocampoapi.dto.AreaCultivoRequestDTO;
import org.ufsm.cadernocampoapi.dto.AreaCultivoResponseDTO;
import org.ufsm.cadernocampoapi.mapper.AreaCultivoMapper;
import org.ufsm.cadernocampoapi.model.AreaCultivo;
import org.ufsm.cadernocampoapi.model.Local;
import org.ufsm.cadernocampoapi.model.Propriedade;
import org.ufsm.cadernocampoapi.repositories.AreaCultivoRepository;
import org.ufsm.cadernocampoapi.repositories.LocalRepository;
import org.ufsm.cadernocampoapi.repositories.PropriedadeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AreaCultivoService {

    private final AreaCultivoRepository areaCultivoRepository;
    private final PropriedadeRepository propriedadeRepository;
    private final LocalRepository localRepository;
    private final AreaCultivoMapper areaCultivoMapper;


    @Transactional
    public AreaCultivoResponseDTO createAreaCultivo(AreaCultivoRequestDTO dto, Long propriedadeId, Long localId) {

        // Busca o local garantindo que ele pertence à propriedade (segurança de hierarquia)
        Local local = localRepository.findByIdAndPropriedadeId(localId, propriedadeId)
                .orElseThrow(() -> new EntityNotFoundException("Local não encontrado nesta propriedade"));

        AreaCultivo area = areaCultivoMapper.toEntity(dto);

        area.setLocal(local);
        areaCultivoRepository.save(area);
        return areaCultivoMapper.toDTO(area);
    }

}
