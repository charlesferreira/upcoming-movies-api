# Upcoming Movies API

API for the [Upcoming Movies](https://upcoming-movies-client.herokuapp.com) application.


## Architecture

* Maven
* Java 11
* Spring Boot 2


## Assumptions

* The TMDb service will be available* 


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


## Client Demo

You can try a [client demo](https://upcoming-movies-client.herokuapp.com/) running on Heroku.


## API Endpoints

The API endpoints can be accessed through the following links:

http://upcoming-movies-api.herokuapp.com/v1/movies/upcoming?page=1 (Upcoming Movies)

http://upcoming-movies-api.herokuapp.com/v1/movies/search?query=star+wars&page=1 (Search)
