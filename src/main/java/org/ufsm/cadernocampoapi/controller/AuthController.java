package org.ufsm.cadernocampoapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ufsm.cadernocampoapi.dto.LoginRequestDTO;
import org.ufsm.cadernocampoapi.dto.LoginResponse;
import org.ufsm.cadernocampoapi.dto.UsuarioRequestDTO;
import org.ufsm.cadernocampoapi.dto.UsuarioResponseDTO;
import org.ufsm.cadernocampoapi.service.AuthService;
import org.ufsm.cadernocampoapi.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {


    private final UsuarioService usuarioService;
    private final AuthService authService;



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody @Valid LoginRequestDTO request){
        String token = authService.login(request);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/registro")
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
