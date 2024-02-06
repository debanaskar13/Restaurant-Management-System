package com.example.first.microservice.utils;

import java.util.Optional;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUtils {

    private JwtUtils() {
    }

    private static final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public static boolean validateToken(String token) {
        return parseToken(token).isPresent();
    }

    private static Optional<Claims> parseToken(String token) {
        JwtParser parser = Jwts.parser()
                .verifyWith(secretKey)
                .build();

        try {
            return Optional.of(parser.parseSignedClaims(token).getPayload());
        } catch (JwtException | IllegalArgumentException ex) {
            log.error("Jwt Exception Occured");
        }
        return Optional.empty();
    }

    public static Optional<String> getUsername(String token) {
        Optional<Claims> claimsOptional = parseToken(token);

        return claimsOptional.map(Claims::getSubject);
    }

}
