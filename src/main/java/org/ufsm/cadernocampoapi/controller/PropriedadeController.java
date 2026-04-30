package org.ufsm.cadernocampoapi.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ufsm.cadernocampoapi.dto.PropriedadeRequestDTO;
import org.ufsm.cadernocampoapi.dto.PropriedadeResponseDTO;
import org.ufsm.cadernocampoapi.service.PropriedadeService;

@RestController("/propriedade")
@AllArgsConstructor
public class PropriedadeController {


    private final PropriedadeService propriedadeService;


    public PropriedadeResponseDTO createPropriedade(@Valid PropriedadeRequestDTO dto){

    }


}
