package org.ufsm.cadernocampoapi.dto;


import lombok.Data;
import lombok.Getter;

public record LoginResponse(
        String token
) {
}
