package javamovie.movie.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Movie {

    private Long id;

    public Movie() {
    }

    public Movie(Long id) {
        this.id = id;
    }
}