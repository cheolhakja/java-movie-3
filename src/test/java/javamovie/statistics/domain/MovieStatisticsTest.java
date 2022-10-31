package javamovie.statistics.domain;

import javamovie.AppConfig;
import javamovie.movie.domain.*;
import javamovie.movie.service.MovieTicketBookingService;
import javamovie.movie.service.MovieTicketBookingServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class MovieStatisticsTest {

    @Test
    public void add_data_and_calculate_top3_seat_per_movie() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MovieTicketBookingService movieTicketBookingService = ac.getBean(MovieTicketBookingServiceImpl.class);
        IMovieRepository movieRepository = new MovieRepository();
        IMovieStastisticsRepository movieStastisticsRepository = new MovieStatisticsRepositoryLocal();

        RowColumnPair A1 = new RowColumnPair(1, 1);
        RowColumnPair A2 = new RowColumnPair(1, 2);
        RowColumnPair A3 = new RowColumnPair(1, 3);
        RowColumnPair A4 = new RowColumnPair(1, 4);
        RowColumnPair B1 = new RowColumnPair(2, 1);
        RowColumnPair B2 = new RowColumnPair(2, 2);
        RowColumnPair B3 = new RowColumnPair(2, 3);
        RowColumnPair C2 = new RowColumnPair(3, 2);

        Movie spiderMan = new Movie(1L);

        movieRepository.add(spiderMan);
        movieTicketBookingService.addSchedule(new MovieSchedule(spiderMan,
                A1, A2, A3, A4, B1, B2, B3, C2));

        movieTicketBookingService.reserve(1,1);
        Map<RowColumnPair, Integer> map = movieStastisticsRepository.topSeatPerMovie(spiderMan, 3);
        Assertions.assertThat(map.get(new RowColumnPair(1,1))).isEqualTo(1);
    }
}