package org.ufsm.cadernocampoapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ufsm.cadernocampoapi.dto.UsuarioRequestDTO;
import org.ufsm.cadernocampoapi.dto.UsuarioResponseDTO;
import org.ufsm.cadernocampoapi.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class Controller {


    private final UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    public void testeCadastro(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {

        usuarioService.registerUsuario(usuarioRequestDTO);
    }

    @GetMapping("/getUser")
    public UsuarioResponseDTO buscarUsuario(@RequestParam String email) {
        return usuarioService.getUsuario(email);
    }

    @GetMapping("/getUsers")
    public List<UsuarioResponseDTO> buscar() {
        return usuarioService.getUsers();
    }
}
