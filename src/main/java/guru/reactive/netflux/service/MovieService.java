package guru.reactive.netflux.service;

import guru.reactive.netflux.domain.Movie;
import guru.reactive.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> events(String movieId);

    Flux<Movie> getStreamAllMovies();

    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();

    Mono<Movie> addMovie(Movie movie);
}
