package movie;

import org.junit.jupiter.api.Test;

public class ReservationTest {

    @Test
    public void testReservation() {
        MovieScheduleRepository movieScheduleRepository = new MovieScheduleRepository();
        movieScheduleRepository.addSchedule(new MovieSchedule(new Movie(1L), 11));
        movieScheduleRepository.reserve(1, 1);
        movieScheduleRepository.reserve(1, 1);
    }
}