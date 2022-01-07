package movie;

public class ReservationTest {

    public void run() {
        MovieScheduleRepository movieScheduleRepository = new MovieScheduleRepository();
        movieScheduleRepository.addSchedule(new MovieSchedule(new Movie(1L), 11));
        movieScheduleRepository.reserve(1, 1); //수동테스트
        movieScheduleRepository.reserve(1, 1);
    }
}