package movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieScheduleRepositoryTest {

    @Test
    public void testMovieScheduleRepository() {
        MovieSchedule movieSchedule = new MovieSchedule(new Movie(1L));
        MovieScheduleRepositoryInterface movieScheduleRepositoryInterface = new MovieScheduleRepositoryImpl();

        movieScheduleRepositoryInterface.saveSchedule(movieSchedule);

        Assertions.assertThat(movieScheduleRepositoryInterface.findSchedule()).isEqualTo(movieSchedule);
    }
}