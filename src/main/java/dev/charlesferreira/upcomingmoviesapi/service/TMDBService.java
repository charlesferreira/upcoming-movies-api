package dev.charlesferreira.upcomingmoviesapi.service;

import dev.charlesferreira.upcomingmoviesapi.util.QueryString;
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

    private static final String URL_TEMPLATE = "https://api.themoviedb.org/3${PATH}?api_key=${TMDB_API_KEY}&${QUERY}";
    private static final String PATH = "PATH";
    private static final String QUERY = "QUERY";
    private static final String TMDB_API_KEY = "TMDB_API_KEY";

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;

    public <T> T get(Class<T> responseType, String path) {
        return get(responseType, path, QueryString.newInstance());
    }

    public <T> T get(Class<T> responseType, String path, QueryString queryString) {
        ResponseEntity<T> response = restTemplate.exchange(
                getUrlFor(path, queryString),
                HttpMethod.GET,
                null,
                ParameterizedTypeReference.forType(responseType));
        return response.getBody();
    }

    private String getUrlFor(String path, QueryString queryString) {
        Map<String, String> substitutes = new HashMap<>();
        substitutes.put(PATH, path);
        substitutes.put(QUERY, queryString.getQuery());
        substitutes.put(TMDB_API_KEY, environment.getProperty(TMDB_API_KEY));
        return new StringSubstitutor(substitutes).replace(URL_TEMPLATE);
    }

}
