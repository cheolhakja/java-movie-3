package javamovie.statistics.domain;

import javamovie.movie.domain.Movie;
import javamovie.movie.domain.RowColumnPair;

public interface IMovieStatistics {

    public RowColumnPair getRowColumn();

    public boolean equalMovie(Movie movie);
}
