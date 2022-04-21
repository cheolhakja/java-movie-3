package javamovie.statistics.domain;

import javamovie.movie.domain.Movie;
import javamovie.movie.domain.RowColumnPair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IMovieStastisticsRepository {

    public void add(IMovieStatistics movieStatistics);

    public void delete();

    public Map<RowColumnPair, Integer> topSeatPerMovie(Movie movie, int NumberOfData);
}
