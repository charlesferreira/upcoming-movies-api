package dev.charlesferreira.upcomingmoviesapi.service.response;

import dev.charlesferreira.upcomingmoviesapi.model.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpcomingMoviesResponse {

    private List<Movie> results;

    private int totalResults;

    private int page;

    private int totalPages;

}
