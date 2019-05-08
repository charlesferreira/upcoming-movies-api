package dev.charlesferreira.upcomingmoviesapi.service;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TMDBService {

    private static final String URL_TEMPLATE = "https://api.themoviedb.org/3${PATH}?api_key=${API_KEY}";
    private static final String PATH = "PATH";
    private static final String API_KEY = "API_KEY";

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;

    public <T> T get(Class<T> clazz, String path) {
        ResponseEntity<T> response = restTemplate.exchange(
                getUrlFor(path),
                HttpMethod.GET,
                null,
                ParameterizedTypeReference.forType(clazz));
        return response.getBody();
    }

    private String getUrlFor(String path) {
        Map<String, String> substitutes = new HashMap<>();
        substitutes.put(PATH, path);
        substitutes.put(API_KEY, environment.getProperty(API_KEY));
        return new StringSubstitutor(substitutes).replace(URL_TEMPLATE);
    }

}
