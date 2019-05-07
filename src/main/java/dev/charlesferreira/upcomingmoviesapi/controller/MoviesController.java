package dev.charlesferreira.upcomingmoviesapi.controller;

import dev.charlesferreira.upcomingmoviesapi.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private static final String API_KEY = "API_KEY";
    private static final String URI_TEMPLATE = "https://api.themoviedb.org/3/movie/%s?api_key=%s";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public Movie get(@PathVariable String id) {
        String url = String.format(URI_TEMPLATE, id, environment.getProperty(API_KEY));
        return restTemplate.getForObject(url, Movie.class);
    }

}
