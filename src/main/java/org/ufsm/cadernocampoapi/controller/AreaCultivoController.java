package org.ufsm.cadernocampoapi.controller;


import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ufsm.cadernocampoapi.dto.AreaCultivoRequestDTO;
import org.ufsm.cadernocampoapi.dto.AreaCultivoResponseDTO;
import org.ufsm.cadernocampoapi.model.Local;
import org.ufsm.cadernocampoapi.model.Propriedade;
import org.ufsm.cadernocampoapi.repositories.LocalRepository;
import org.ufsm.cadernocampoapi.repositories.PropriedadeRepository;
import org.ufsm.cadernocampoapi.service.AreaCultivoService;

@RestController
@RequestMapping("/propriedade/{propriedadeId}/local/{localId}/area-cultivo")
@AllArgsConstructor
public class AreaCultivoController {

    private final AreaCultivoService areaCultivoService;
    private final PropriedadeRepository propriedadeRepository;
    private final LocalRepository localRepository;


    @PostMapping
    public ResponseEntity<AreaCultivoResponseDTO> createAreaCultivo(
            @Valid @RequestBody AreaCultivoRequestDTO dto,
            @PathVariable Long propriedadeId,
            @PathVariable Long localId
            ){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(areaCultivoService.createAreaCultivo(dto, propriedadeId, localId));


    }

}
