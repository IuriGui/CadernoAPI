package org.ufsm.cadernocampoapi.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.ufsm.cadernocampoapi.dto.UsuarioRequestDTO;
import org.ufsm.cadernocampoapi.dto.UsuarioResponseDTO;
import org.ufsm.cadernocampoapi.mapper.UsuarioMapper;
import org.ufsm.cadernocampoapi.model.*;
import org.ufsm.cadernocampoapi.repositories.ProdutorRepository;
import org.ufsm.cadernocampoapi.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final ProdutorRepository produtorRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, ProdutorRepository produtorRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.produtorRepository = produtorRepository;
    }

    @Transactional
    public void registerUsuario(UsuarioRequestDTO usuarioRequestDTO) {

        // 1. Conversão usando o Mapper
        Usuario usr = usuarioMapper.toEntity(usuarioRequestDTO);
        MecanismoControle mec = usuarioMapper.toEntity(usuarioRequestDTO.getMecanismo());
        List<ProgramaComercializacao> li = usuarioMapper.toEntityList(usuarioRequestDTO.getProgramaComercializacao());

        // 2. Usando o Builder para montar o Produtor de forma elegante
        Produtor prd = Produtor.builder()
                .nome(usuarioRequestDTO.getNome())
                .mecanismoControle(mec)
                .programaComercializacao(li)
                .usuario(usr)
                .build();

        if (mec != null) {
            mec.setProdutor(prd);
        }
        if (li != null) {
            li.forEach(programa -> programa.setProdutor(prd));
        }

        usr.setProdutor(prd);

        // 5. Salvar APENAS o Usuário. O Cascade cuida de salvar o Produtor, o Mecanismo e a Lista.
        usuarioRepository.save(usr);
    }


    public UsuarioResponseDTO getUsuario(String email) {

        Optional<Usuario> u = usuarioRepository.findByEmail(email);

        if (u.isPresent()) {
            return usuarioMapper.toDTO(u.get());
        }
        throw new RuntimeException("Faltou o caba master");


    }

    public List<UsuarioResponseDTO> getUsers() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .toList();
    }


    public String login(){
        return "token";
    }



}
