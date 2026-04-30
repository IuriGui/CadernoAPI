package org.ufsm.cadernocampoapi.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ufsm.cadernocampoapi.dto.PropriedadeRequestDTO;
import org.ufsm.cadernocampoapi.dto.PropriedadeResponseDTO;
import org.ufsm.cadernocampoapi.service.PropriedadeService;

@RestController
@RequestMapping("/propriedade")
@AllArgsConstructor
public class PropriedadeController {


    private final PropriedadeService propriedadeService;


    private ResponseEntity<PropriedadeResponseDTO> criarPropriedade(PropriedadeRequestDTO propriedadeRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propriedadeService.criarPropriedade(propriedadeRequestDTO));
    }

}
