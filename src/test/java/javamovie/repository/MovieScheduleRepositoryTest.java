package javamovie.repository;

import javamovie.domain.Movie;
import javamovie.domain.MovieSchedule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieScheduleRepositoryTest {

    @Test
    public void testMovieScheduleRepository() {
        MovieSchedule movieSchedule = new MovieSchedule(new Movie(1L));
        MovieScheduleRepository movieScheduleRepository = new MovieScheduleRepositoryImpl();

        movieScheduleRepository.saveSchedule(movieSchedule);

        Assertions.assertThat(movieScheduleRepository.findSchedule()).isEqualTo(movieSchedule);
    }
}