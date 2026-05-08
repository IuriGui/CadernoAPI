package org.ufsm.cadernocampoapi.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.ufsm.cadernocampoapi.dto.LoginRequestDTO;
import org.ufsm.cadernocampoapi.model.Usuario;
import org.ufsm.cadernocampoapi.repositories.UsuarioRepository;
import org.ufsm.cadernocampoapi.security.JwtService;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;


    public String login(LoginRequestDTO dto){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.email(), dto.password())
        );

        Usuario usuario = usuarioRepository.findByEmail(dto.email())
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));

        Long produtorId = usuario.getProdutor().getId();

        String token = jwtService.gerarToken(dto.email(), produtorId);

        return token;


    }




}
