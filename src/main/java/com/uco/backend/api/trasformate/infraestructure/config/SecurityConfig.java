package com.uco.backend.api.trasformate.infraestructure.config;

import com.uco.backend.api.trasformate.infraestructure.jwt.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    public SecurityConfig(JWTAuthorizationFilter jwtAuthorizationFilter) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
                aut -> aut.requestMatchers("/api/v1/users/all").hasAnyRole("ADMIN")
                        .requestMatchers("/api/v1/users/upd/role").hasRole("ADMIN")
                        .requestMatchers("/api/v1/users/del/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/areas/crear").hasRole("ADMIN")
                        .requestMatchers("/api/v1/areas/all").hasRole("ADMIN")
                        .requestMatchers("/api/v1/areas/del/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/areas/upd/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/exercise/crear").hasRole("TEACHER")
                        .requestMatchers("/api/v1/exercise/all").hasRole("TEACHER")
                        .requestMatchers("/api/v1/routines/all").hasAnyRole("TEACHER" , "USER")
                        .requestMatchers("/api/v1/routines/crear").hasRole("TEACHER")
                        .requestMatchers("/api/v1/class/crear").hasRole("TEACHER")
                        .requestMatchers("/api/v1/class/all").hasAnyRole("TEACHER" , "USER" )
                        .requestMatchers("/api/v1/users/upd/routine").hasRole("USER")
                        .requestMatchers("/api/v1/class/asis").hasRole("USER")
                        .requestMatchers("/api/v1/seg/**").permitAll().anyRequest().authenticated()
        ).addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }

}
