package org.ufsm.cadernocampoapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.ufsm.cadernocampoapi.dto.PropriedadeRequestDTO;
import org.ufsm.cadernocampoapi.mapper.PropriedadeMapper;
import org.ufsm.cadernocampoapi.model.Produtor;
import org.ufsm.cadernocampoapi.model.ProdutorPropriedade;
import org.ufsm.cadernocampoapi.model.Propriedade;
import org.ufsm.cadernocampoapi.model.Usuario;
import org.ufsm.cadernocampoapi.repositories.ProdutorRepository;
import org.ufsm.cadernocampoapi.repositories.PropriedadeRepository;
import org.ufsm.cadernocampoapi.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // Muito importante: Faz um "rollback" no banco após o teste, mantendo ele limpo!
class PropriedadeServiceTest {

    @Autowired
    private PropriedadeRepository propriedadeRepository;

    @Autowired
    private ProdutorRepository produtorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PropriedadeMapper propriedadeMapper;

    @Test
    void deveCriarPropriedadeEVincularAoProdutor() {

        // =====================================================================
        // 1. ARRANGE (PREPARAÇÃO)
        // Criamos um usuário/produtor falso para não depender de dados do banco
        // =====================================================================
        Usuario usr = Usuario.builder()
                .email("teste_prop@ufsm.br")
                .password("123")
                .build();

        Produtor produtorFake = Produtor.builder()
                .nome("Zé da Silva")
                .usuario(usr)
                .build();

        // Amarração bidirecional antes de salvar
        usr.setProdutor(produtorFake);

        // Salva o usuário (e o produtor vai junto pelo Cascade)
        usuarioRepository.save(usr);

        Long idProdutorParaTestar = produtorFake.getId();

        // =====================================================================
        // 2. ACT (AÇÃO - O SEU CÓDIGO DA SERVICE ADAPTADO)
        // =====================================================================

        // Monta propriedade usando o Builder
        Propriedade prop = Propriedade.builder()
                .nome("Sítio do Pica-Pau")
                .cep("97000-000")
                .cidade("Santa Maria")
                .estado("RS")
                .areaTotal(50.0)
                .areaPropria(50.0)
                .build();

        // Procura produtor no banco usando o ID gerado na etapa 1
        Optional<Produtor> produtor = produtorRepository.findById(idProdutorParaTestar);

        if (produtor.isEmpty()) {
            throw new RuntimeException("Num existe");
        }

        // Cria a relação (ProdutorPropriedade)
        ProdutorPropriedade relacao = new ProdutorPropriedade();
        relacao.setPropriedade(prop);
        relacao.setProdutor(produtor.get());
        relacao.setPapel("PROPRIETARIO"); // O banco exige o papel NOT NULL!

        // Adiciona a relação na propriedade
        prop.setProdutores(List.of(relacao));

        // Salva a propriedade (junto com a relação)
        Propriedade propriedadeSalva = propriedadeRepository.save(prop);

        // =====================================================================
        // 3. ASSERT (VERIFICAÇÃO)
        // Confirma matematicamente se o código fez o que deveria fazer
        // =====================================================================
        assertNotNull(propriedadeSalva.getId(), "O ID da propriedade não deveria ser nulo após o save");
        assertEquals("Sítio do Pica-Pau", propriedadeSalva.getNome());
        assertEquals(1, propriedadeSalva.getProdutores().size(), "A propriedade deve ter 1 produtor vinculado");
        assertEquals("PROPRIETARIO", propriedadeSalva.getProdutores().get(0).getPapel());
    }

    @Test
    void testeParaConverterDTOtoEntity(){
        PropriedadeRequestDTO dto = new PropriedadeRequestDTO();
        dto.setNome("Cidade bacana");
        dto.setAreaPropria(10D);
        dto.setCep("123");
        dto.setCidade("osorio");
        dto.setAreaProducaoVegetal(10D);
        Propriedade p = propriedadeMapper.toEntity(dto);
        System.out.println(p);

    }

}