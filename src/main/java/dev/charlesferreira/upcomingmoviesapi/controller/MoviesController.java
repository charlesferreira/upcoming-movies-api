package dev.charlesferreira.upcomingmoviesapi.controller;

import dev.charlesferreira.upcomingmoviesapi.service.TMDBService;
import dev.charlesferreira.upcomingmoviesapi.service.response.UpcomingMoviesResponse;
import dev.charlesferreira.upcomingmoviesapi.util.QueryString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private static final String GET_UPCOMING= "/movie/upcoming";

    @Autowired
    TMDBService tmdbService;

    @GetMapping("/upcoming")
    @Cacheable("upcoming-movies")
    public UpcomingMoviesResponse getUpcoming(@RequestParam(value = "page", defaultValue = "1") int page) {
        QueryString queryString = QueryString.fromParams(Map.of("page", page));
        return tmdbService.get(UpcomingMoviesResponse.class, GET_UPCOMING, queryString);
    }

}
