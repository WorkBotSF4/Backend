package com.uco.backend.api.trasformate.infraestructure.jwt;

import com.uco.backend.api.trasformate.application.CustomUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import static com.uco.backend.api.trasformate.infraestructure.jwt.Constants.*;

public class JWTValidate {
    public static boolean tokenExists(HttpServletRequest request, HttpServletResponse response) {
        String header = request.getHeader(HEADER_AUTHORIZATION);
        if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX))
            return false;
        return true;
    }

    public static Claims JWTValid(HttpServletRequest request) {
        try {

            String jwtToken = request.getHeader(HEADER_AUTHORIZATION).replace(TOKEN_BEARER_PREFIX, "");

            Claims claims = null;
            claims = Jwts.parserBuilder().setSigningKey(getSecretKey(SUPER_SECRET_KEY)).build().parseClaimsJws(jwtToken).getBody();
            return Jwts.parserBuilder()
                .setSigningKey(getSecretKey(SUPER_SECRET_KEY))
                .build()
                .parseClaimsJwt(jwtToken)
                .getBody();

        }catch (Exception e){
            e.printStackTrace();
            SecurityContextHolder.clearContext();
            return null;
        }
    }

    public static void setAuthentication(Claims claims, CustomUserDetailService customUserDetailService) {
        UserDetails userDetails = customUserDetailService.loadUserByUsername(claims.getSubject());
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
