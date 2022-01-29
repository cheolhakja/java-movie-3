package movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservationTest {

    @Test
    public void testReservationReturnBoolean() {
        MovieScheduleRepository movieScheduleRepository = new MovieScheduleRepository();

        movieScheduleRepository.addSchedule(new MovieSchedule(new Movie(1L)));

        Assertions.assertThat(movieScheduleRepository.reserve(1, 1)).isTrue();
        Assertions.assertThatThrownBy(() -> {
            movieScheduleRepository.reserve(1, 1);
        }).isInstanceOf(CannotReserveException.class);

        movieScheduleRepository.printSeats();
    }
}