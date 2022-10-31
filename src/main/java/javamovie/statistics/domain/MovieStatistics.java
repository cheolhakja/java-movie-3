package javamovie.statistics.domain;

import javamovie.movie.domain.Movie;
import javamovie.movie.domain.MovieSchedule;
import javamovie.movie.domain.RowColumnPair;

public class MovieStatistics implements IMovieStatistics {

    private RowColumnPair rowColumnPair;

    private MovieSchedule movieSchedule;

    public MovieStatistics(RowColumnPair rowColumnPair,
                           MovieSchedule movieSchedule) {
        this.rowColumnPair = rowColumnPair;
        this.movieSchedule = movieSchedule;
    }

    @Override
    public RowColumnPair getRowColumn() {
        return this.rowColumnPair;
    }

    public boolean equalMovie(Movie movie) {
        return this.movieSchedule.equalMovie(movie);
    }
}
