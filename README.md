# Upcoming Movies API

API for the Upcoming Movies application. You can try a [live demo](https://upcoming-movies-client.herokuapp.com/)*.

\* *Please notice that the first request might take quite long to return, since Heroku puts the app to sleep from time to time.*


## Architecture

* [Maven](https://maven.apache.org/)
* [Java 11](https://openjdk.java.net/projects/jdk/11/)
* [Spring Boot 2](https://spring.io/projects/spring-boot)


## Assumptions

* The [TMDb][TMDb] service will be available


## Build instructions

### Environment variables

The service expects the following environment variables to be set:

**`TMDB_API_KEY`**:
a valid API key provided by TMDb for using their service

**`CLIENT_URL`**:
the frontend's URL, for allowing for cross-origin requests (pass `*` to allow from any origin)


## Third-party libraries

[Lombok](https://projectlombok.org/):
used for reducing POJO boilerplate in the model and response classes

[Apache Commons](https://commons.apache.org/):
used for parsing endpoint URL template strings


## API Endpoints

The API endpoints can be accessed through the following links:

http://upcoming-movies-api.herokuapp.com/v1/movies/upcoming?page=1 (Upcoming Movies)

http://upcoming-movies-api.herokuapp.com/v1/movies/search?query=star+wars&page=1 (Search)




[TMDb]: https://developers.themoviedb.org/3
