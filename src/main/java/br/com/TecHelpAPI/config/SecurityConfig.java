package br.com.TecHelpAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Os caminhos aqui são relativos ao context-path /techelp/api
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/ticket/**").permitAll()
                        .requestMatchers("/category/**").permitAll()
                        .requestMatchers("/skill/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
    }

