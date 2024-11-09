package com.uco.backend.api.trasformate.infraestructure.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.uco.backend.api.trasformate.infraestructure.jwt.Constants.*;

@Service
public class JWTGenerator {
    public String getToken(String username) {

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(
                SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().toString()
        );


        String token = Jwts.builder()
                .setId("workbot")
                .setSubject(username)
                .claim("authorities" , authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(getSecretKey(SUPER_SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();
        return "Bearer " + token;
    }



}
