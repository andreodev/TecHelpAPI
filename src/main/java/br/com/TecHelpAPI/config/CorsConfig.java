package br.com.TecHelpAPI.config;

<<<<<<< HEAD
=======
import org.springframework.context.annotation.Bean;
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins(
                "http://localhost:5173"
            )
            .allowedMethods("*")
            .allowedHeaders("*")
            .exposedHeaders("Authorization")
            .allowCredentials(true)
            .maxAge(3600);
    }
}