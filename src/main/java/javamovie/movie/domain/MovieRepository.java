package javamovie.movie.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class MovieRepository implements IMovieRepository {

    private static Map<Integer, Movie> movieRepository = new HashMap<>();
    private int primaryKey = 0;

    @Override
    public void add(Movie movie) {
        this.primaryKey++;
        movieRepository.put(this.primaryKey, movie);
    }

    @Override
    public Collection<Movie> findAll() {
        return movieRepository.values();
        //refactor: 반환타입, do not return null
    }
}
