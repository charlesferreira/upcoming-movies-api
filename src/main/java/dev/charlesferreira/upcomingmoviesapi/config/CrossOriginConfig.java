package dev.charlesferreira.upcomingmoviesapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    private static final String PATH_PATTERN = "/**";

    @Autowired
    Environment environment;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping(PATH_PATTERN)
                .allowedOrigins(getAllowedOrigins());
    }

    public String getAllowedOrigins() {
        return environment.getProperty("CLIENT_URL");
    }

}
