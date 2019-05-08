package dev.charlesferreira.upcomingmoviesapi.service;

import dev.charlesferreira.upcomingmoviesapi.model.Genre;
import dev.charlesferreira.upcomingmoviesapi.service.response.GenresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GenresService {

    private static final String GET_LIST = "/genre/movie/list";

    @Autowired
    TMDBService tmdbService;

    @Cacheable("genres")
    public Map<Long, Genre> genres() {
        return tmdbService.get(GenresResponse.class, GET_LIST)
                .getGenres()
                .stream()
                .collect(Collectors.toMap(Genre::getId, Function.identity()));
    }

}
