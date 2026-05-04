package org.ufsm.cadernocampoapi.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ufsm.cadernocampoapi.dto.AnotacaoRequestDTO;
import org.ufsm.cadernocampoapi.dto.AnotacaoResponseDTO;
import org.ufsm.cadernocampoapi.service.AnotacaoService;

@RestController
@RequestMapping("/area-cultivo/{areaId}/anotacao")
@AllArgsConstructor
public class AnotacaoController {

    private final AnotacaoService anotacaoService;


    @PostMapping
    public ResponseEntity<AnotacaoResponseDTO> createAnotacao(
            @PathVariable Long areaId,
            @Valid @RequestBody AnotacaoRequestDTO anotacaoRequestDTO
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(anotacaoService.createAnotacao(areaId, anotacaoRequestDTO));
    }


}
