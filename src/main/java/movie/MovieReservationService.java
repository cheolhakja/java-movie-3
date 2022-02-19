package movie;

public interface MovieReservationService {

    public boolean reserve(int row, int column);

    public void addSchedule(MovieSchedule movieSchedule);

    public void printSeats();
}