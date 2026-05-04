package org.ufsm.cadernocampoapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ufsm.cadernocampoapi.dto.LocalRequestDTO;
import org.ufsm.cadernocampoapi.dto.LocalResponseDTO;
import org.ufsm.cadernocampoapi.model.Local;
import org.ufsm.cadernocampoapi.repositories.LocalRepository;
import org.ufsm.cadernocampoapi.service.LocalService;

@RestController
@RequestMapping("/propriedade/{propriedadeId}/local")
@AllArgsConstructor
public class LocalController {

    private final LocalRepository localRepository;
    private final LocalService localService;


    @PostMapping
    public ResponseEntity<LocalResponseDTO> createLocal(
            @Valid @RequestBody LocalRequestDTO dto,
            @PathVariable Long propriedadeId) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(localService.criarLocal(dto, propriedadeId));

    }




}
