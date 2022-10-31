package javamovie.statistics.service;

import javamovie.movie.domain.EventAddStatistics;
import javamovie.statistics.domain.IMovieStastisticsRepository;
import javamovie.statistics.domain.MovieStatistics;
import javamovie.statistics.domain.MovieStatisticsRepositoryLocal;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StatisticsAddEventListener implements ApplicationListener<EventAddStatistics> {

    private IMovieStastisticsRepository movieStastisticsRepository = new MovieStatisticsRepositoryLocal();

    public StatisticsAddEventListener() {
    }

    public StatisticsAddEventListener(IMovieStastisticsRepository movieStastisticsRepository) {
        this.movieStastisticsRepository = movieStastisticsRepository;
    }

    @Override
    public void onApplicationEvent(EventAddStatistics event) {
        movieStastisticsRepository.add(new MovieStatistics(event.getRowColumnPair(), event.getMovieSchedule()));
    }
}
