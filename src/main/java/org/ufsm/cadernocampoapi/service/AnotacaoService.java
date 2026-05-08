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
import org.ufsm.cadernocampoapi.model.Insumo;
import org.ufsm.cadernocampoapi.repositories.AnotacaoRepository;
import org.ufsm.cadernocampoapi.repositories.AreaCultivoRepository;
import org.ufsm.cadernocampoapi.repositories.AtividadeRepository;
import org.ufsm.cadernocampoapi.repositories.InsumoRepository;


@Service
@AllArgsConstructor
public class AnotacaoService {

    private final AreaCultivoRepository areaCultivoRepository;
    private final AtividadeRepository atividadeRepository;
    private final AnotacaoRepository anotacaoRepository;
    private final AnotacaoMapper anotacaoMapper;
    private final InsumoRepository insumoRepository;

    @Transactional
    public AnotacaoResponseDTO createAnotacao(Long areaId, AnotacaoRequestDTO dto) {


        AreaCultivo area = areaCultivoRepository.findById(areaId)
                .orElseThrow(() -> new EntityNotFoundException("Área de cultivo não encontrada"));

        Atividade atividade = atividadeRepository.findById(dto.atividadeId())
                .orElseThrow(() -> new EntityNotFoundException("Atividade não encontrada"));


        // TODO: Verificar se o insumo é da mesma propriedade que o local.
        Insumo insumo = insumoRepository.findById(dto.insumoId())
                .orElseThrow(() -> new EntityNotFoundException("Insumo não encontrado"));



        Anotacao anotacao = anotacaoMapper.toEntity(dto);


        anotacao.setAreaCultivo(area);
        anotacao.setAtividade(atividade);


        Anotacao anotacaoSalva = anotacaoRepository.save(anotacao);

        return anotacaoMapper.toDTO(anotacaoSalva);
    }
}
