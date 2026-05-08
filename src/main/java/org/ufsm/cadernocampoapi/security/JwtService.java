package org.ufsm.cadernocampoapi.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {


    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;


    public String gerarToken(String email, Long produtorId) {
        return JWT.create()
                .withSubject(email)
                .withClaim("produtorId", produtorId)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(Algorithm.HMAC256(secret));
    }

    public String extrairEmail(String token) {
        return validarToken(token).getSubject();
    }



    public Long extrairProdutorId(String token) {
        return validarToken(token).getClaim("produtorId").asLong();
    }


    public boolean tokenValido(String token) {
        try {
            validarToken(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }


    private DecodedJWT validarToken(String token) {
        return JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token);
    }

}
