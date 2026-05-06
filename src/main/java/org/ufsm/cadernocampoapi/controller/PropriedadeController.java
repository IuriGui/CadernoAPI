package org.ufsm.cadernocampoapi.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ufsm.cadernocampoapi.dto.CompartilharAcessoDTO;
import org.ufsm.cadernocampoapi.dto.PropriedadeRequestDTO;
import org.ufsm.cadernocampoapi.dto.PropriedadeResponseDTO;
import org.ufsm.cadernocampoapi.service.PropriedadeService;

@RestController
@RequestMapping("/propriedade")
@AllArgsConstructor
public class PropriedadeController {


    private final PropriedadeService propriedadeService;


    @PostMapping
    public ResponseEntity<PropriedadeResponseDTO> createPropriedade(@Valid @RequestBody PropriedadeRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(propriedadeService.criarPropriedade(dto));
    }


    @PostMapping("/{id}/share")
    public ResponseEntity<Void> shareAccess(@PathVariable Long id, @Valid @RequestBody CompartilharAcessoDTO request){
        propriedadeService.compartilharAcesso(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
