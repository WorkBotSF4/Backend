package com.uco.backend.api.trasformate.infraestructure.jwt;

import com.uco.backend.api.trasformate.application.CustomUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.uco.backend.api.trasformate.infraestructure.jwt.JWTValidate.*;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final CustomUserDetailService customUserDetailService;

    public JWTAuthorizationFilter(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (tokenExists(request , response)){
                Claims claims = JWTValid(request);
                if (claims.get("authorities") != null){

                    setAuthentication(claims, customUserDetailService);

                    System.out.println("Entra al if con las authorities : -> " + claims.get("authorities") );
                }else {

                    SecurityContextHolder.clearContext();

                }
            }else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e ) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

    }
}
