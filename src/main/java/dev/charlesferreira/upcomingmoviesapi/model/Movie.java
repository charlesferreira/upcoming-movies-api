package dev.charlesferreira.upcomingmoviesapi.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.charlesferreira.upcomingmoviesapi.service.databind.MovieDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@JsonDeserialize(using = MovieDeserializer.class)
public class Movie {

    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    private String title;

    private String overview;

    private String posterPath;

    private String backdropPath;

    private List<Genre> genres;

    private Date releaseDate;

    public void setPosterPath(String path) {
        if (!path.isBlank())
            posterPath = IMAGE_BASE_URL + path;
    }

    public void setBackdropPath(String path) {
        if (!path.isBlank())
            backdropPath = IMAGE_BASE_URL + path;
    }

}
