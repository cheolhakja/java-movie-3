package movie;

public class MovieReservationService {

    private final MovieScheduleRepository movieScheduleRepository = new MovieScheduleRepository();

    public boolean reserve(int row, int column) {
        return movieScheduleRepository.reserve(row, column);
    }

    public void addSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.addSchedule(movieSchedule);
    }

    public void printSeats() {
        movieScheduleRepository.printSeats();
    }
}