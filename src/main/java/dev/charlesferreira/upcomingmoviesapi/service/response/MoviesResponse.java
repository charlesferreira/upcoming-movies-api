package dev.charlesferreira.upcomingmoviesapi.service.response;

import dev.charlesferreira.upcomingmoviesapi.model.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MoviesResponse {

    private List<Movie> results;

    private int totalResults;

    private int page;

    private int totalPages;

    public static MoviesResponse empty() {
        return new MoviesResponse();
    }
}
