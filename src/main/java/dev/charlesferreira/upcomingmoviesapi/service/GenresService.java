package dev.charlesferreira.upcomingmoviesapi.service;

import dev.charlesferreira.upcomingmoviesapi.model.Genre;
import dev.charlesferreira.upcomingmoviesapi.service.response.GenreListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresService {

    private static final String GET_LIST = "/genre/movie/list";

    @Autowired
    TMDBService tmdbService;

    @Cacheable("genres")
    public List<Genre> genres() {
        return tmdbService.get(GenreListResponse.class, GET_LIST).getGenres();
    }

}
