package dev.charlesferreira.upcomingmoviesapi.controller;

import dev.charlesferreira.upcomingmoviesapi.model.Genre;
import dev.charlesferreira.upcomingmoviesapi.service.response.GenreListResponse;
import dev.charlesferreira.upcomingmoviesapi.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenresController {

    private static final String GET_LIST = "/genre/movie/list";

    @Autowired
    TMDBService tmdbService;

    @GetMapping
    @Cacheable("genres")
    public List<Genre> getList() {
        return tmdbService.get(GenreListResponse.class, GET_LIST).getGenres();
    }

}
