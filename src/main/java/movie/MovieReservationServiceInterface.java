package movie;

public interface MovieReservationServiceInterface {

    public boolean reserve(int row, int column);

    public void addSchedule(MovieSchedule movieSchedule);

    public void printSeats();
}