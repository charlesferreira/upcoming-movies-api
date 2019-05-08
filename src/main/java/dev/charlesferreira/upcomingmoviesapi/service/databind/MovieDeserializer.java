package dev.charlesferreira.upcomingmoviesapi.service.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.charlesferreira.upcomingmoviesapi.model.Genre;
import dev.charlesferreira.upcomingmoviesapi.model.Movie;
import dev.charlesferreira.upcomingmoviesapi.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieDeserializer extends StdDeserializer<Movie> {

    @Autowired
    GenresService genresService;

    @SuppressWarnings("unused")
    public MovieDeserializer() {
        this(null);
    }

    @SuppressWarnings("WeakerAccess")
    public MovieDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Movie deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Movie movie = new Movie();
        movie.setTitle(node.get("title").asText());
        movie.setOverview(node.get("overview").asText());
        movie.setPosterPath(node.get("poster_path").asText(""));
        movie.setBackdropPath(node.get("backdrop_path").asText(""));
        movie.setReleaseDate(getReleaseDate(node));

        try {
            movie.setGenres(getGenres(node));
        } catch (Exception ex) {
            movie.setGenres(getGenresFromIdList(node));
        }

        return movie;
    }

    private List<Genre> getGenres(JsonNode node) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.readerFor(new TypeReference<List<Genre>>() {
        });
        return reader.readValue(node.get("genres"));
    }

    private List<Genre> getGenresFromIdList(JsonNode node) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.readerFor(new TypeReference<List<Long>>() {
        });
        List<Long> ids = reader.readValue(node.get("genre_ids"));
        return ids
                .stream()
                .map(id -> genresService.genres().get(id))
                .collect(Collectors.toList());
    }

    private Date getReleaseDate(JsonNode node) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = node.get("release_date").asText();
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
