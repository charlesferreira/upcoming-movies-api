package dev.charlesferreira.upcomingmoviesapi.controller;

import dev.charlesferreira.upcomingmoviesapi.service.TMDBService;
import dev.charlesferreira.upcomingmoviesapi.service.response.MoviesResponse;
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
    private static final String GET_SEARCH = "/search/movie";

    @Autowired
    TMDBService tmdbService;

    @GetMapping("/upcoming")
    @Cacheable("upcoming-movies")
    public MoviesResponse getUpcoming(@RequestParam(value = "page", defaultValue = "1") int page) {
        QueryString queryString = QueryString.fromParams(Map.of("page", page));
        return tmdbService.get(MoviesResponse.class, GET_UPCOMING, queryString);
    }

    @GetMapping("/search")
    public MoviesResponse getSearch(
            @RequestParam(value = "query", defaultValue = "") String query,
            @RequestParam(value = "page", defaultValue = "1") int page) {

        if (query.isBlank()) {
            return MoviesResponse.empty();
        }

        Map<String, Object> params = Map.of("page", page, "query", query);
        QueryString queryString = QueryString.fromParams(params);
        return tmdbService.get(MoviesResponse.class, GET_SEARCH, queryString);
    }

}
