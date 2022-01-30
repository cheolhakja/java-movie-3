package movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MovieReservationServiceTest {

    @Test
    public void testReservation() {
        MovieReservationServiceInterface movieReservationService = new MovieReservationServiceImpl();

        movieReservationService.addSchedule(new MovieSchedule(new Movie(1L)));

        assertThat(movieReservationService.reserve(1, 1)).isTrue();
        assertThatThrownBy(() -> {
            movieReservationService.reserve(1, 1);
        }).isInstanceOf(CannotReserveException.class);
    }
}