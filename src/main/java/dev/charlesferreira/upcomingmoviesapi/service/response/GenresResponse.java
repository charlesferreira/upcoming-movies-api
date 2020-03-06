package dev.charlesferreira.upcomingmoviesapi.service.response;

import dev.charlesferreira.upcomingmoviesapi.model.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenresResponse {

    private List<Genre> genres;

}
