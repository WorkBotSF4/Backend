package com.uco.backend.api.trasformate.infraestructure.jwt;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    public static final String SUPER_SECRET_KEY = "84efc89ef6b14648bdb12bcdc085160584efc89ef6b14648bdb12bcdc0851646408b1258";
    public static final long TOKEN_EXPIRATION_TIME = 5100000; //51Minutos

    public static Key getSecretKey(String secretKey) {
        byte [] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
