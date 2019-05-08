package dev.charlesferreira.upcomingmoviesapi.controller;

import dev.charlesferreira.upcomingmoviesapi.model.Genre;
import dev.charlesferreira.upcomingmoviesapi.model.GenreList;
import dev.charlesferreira.upcomingmoviesapi.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private TMDBService tmdbService;

    @GetMapping
    public List<Genre> getAll() {
        return tmdbService.get(GenreList.class, "/genre/movie/list").getGenres();
    }
}
