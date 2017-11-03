package guru.reactive.netflux.controllers;

import guru.reactive.netflux.domain.Movie;
import guru.reactive.netflux.domain.MovieEvent;
import guru.reactive.netflux.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> streamMovieEvents(@PathVariable String id) {
        return movieService.events(id);
    }

    @GetMapping(value = "/{id}")
    Mono<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Movie> getAllMovies() {
        return movieService.getStreamAllMovies();
    }

    @PostMapping
    Mono<ResponseEntity<Movie>> addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie)
                .map(savedMovie -> new ResponseEntity<Movie>(savedMovie, HttpStatus.CREATED));
    }
}
