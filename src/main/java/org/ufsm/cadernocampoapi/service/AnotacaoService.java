package org.ufsm.cadernocampoapi.service;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ufsm.cadernocampoapi.dto.AnotacaoRequestDTO;
import org.ufsm.cadernocampoapi.dto.AnotacaoResponseDTO;
import org.ufsm.cadernocampoapi.mapper.AnotacaoMapper;
import org.ufsm.cadernocampoapi.model.Anotacao;
import org.ufsm.cadernocampoapi.model.AreaCultivo;
import org.ufsm.cadernocampoapi.model.Atividade;
import org.ufsm.cadernocampoapi.repositories.AnotacaoRepository;
import org.ufsm.cadernocampoapi.repositories.AreaCultivoRepository;
import org.ufsm.cadernocampoapi.repositories.AtividadeRepository;


@Service
@AllArgsConstructor
public class AnotacaoService {

    private final AreaCultivoRepository areaCultivoRepository;
    private final AtividadeRepository atividadeRepository;
    private final AnotacaoRepository anotacaoRepository;
    private final AnotacaoMapper anotacaoMapper;

    @Transactional
    public AnotacaoResponseDTO createAnotacao(Long areaId, AnotacaoRequestDTO dto) {

        // 1. Busca as dependências (getReferenceById é eficiente para associações)
        AreaCultivo area = areaCultivoRepository.findById(areaId)
                .orElseThrow(() -> new EntityNotFoundException("Área de cultivo não encontrada"));

        Atividade atividade = atividadeRepository.findById(dto.atividadeId())
                .orElseThrow(() -> new EntityNotFoundException("Atividade não encontrada"));

        // 2. Converte campos simples do DTO
        Anotacao anotacao = anotacaoMapper.toEntity(dto);

        // 3. Faz as associações manuais (Onde o MapStruct não alcança)
        anotacao.setAreaCultivo(area);
        anotacao.setAtividade(atividade);

        // 4. Salva e retorna
        Anotacao anotacaoSalva = anotacaoRepository.save(anotacao);

        return anotacaoMapper.toDTO(anotacaoSalva);
    }
}
