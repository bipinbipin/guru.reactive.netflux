package guru.reactive.netflux.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {

    @Id
    private String id;

    @NonNull
    private String title;
}
