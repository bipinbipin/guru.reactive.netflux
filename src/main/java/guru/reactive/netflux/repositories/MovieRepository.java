package guru.reactive.netflux.repositories;

import guru.reactive.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

    @Tailable // Use a tailable cursor
    Flux<Movie> findWithTailableCursorBy();
}
