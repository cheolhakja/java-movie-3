package javamovie.movie.domain;

import java.util.Collection;

public interface IMovieRepository {

    public void add(Movie movie);

    public Collection<Movie> findAll();
}
