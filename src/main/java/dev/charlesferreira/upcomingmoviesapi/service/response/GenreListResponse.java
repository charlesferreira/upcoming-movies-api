package dev.charlesferreira.upcomingmoviesapi.service.response;

import dev.charlesferreira.upcomingmoviesapi.model.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GenreListResponse {

    private List<Genre> genres;

}
