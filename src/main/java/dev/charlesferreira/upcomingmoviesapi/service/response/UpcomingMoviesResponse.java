package dev.charlesferreira.upcomingmoviesapi.service.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.charlesferreira.upcomingmoviesapi.model.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpcomingMoviesResponse {

    private List<Movie> results;

    private int totalResults;

    private int page;

    private int totalPages;

}
