package movie;

public class MovieReservationController {

    public void run() {
        Input input = new HardcodingInput();
        int menu = input.inputMenu();
        MovieReservationService movieReservationService = new MovieReservationService();
        movieReservationService.addSchedule(new MovieSchedule(new Movie(1L), 11));

        switch (menu) {
            case 1:
                movieReservationService.printSeats();
                int row = input.inputRow();
                int column = input.inputColumn();
                movieReservationService.reserve(row, column);
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("d");
        }
    }
}