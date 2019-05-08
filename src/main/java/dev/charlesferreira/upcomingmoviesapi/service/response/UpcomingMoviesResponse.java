package dev.charlesferreira.upcomingmoviesapi.service.response;

import dev.charlesferreira.upcomingmoviesapi.model.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpcomingMoviesResponse {

    private List<Movie> results;

    private int totalResults;

    private int page;

    private int totalPages;

}
