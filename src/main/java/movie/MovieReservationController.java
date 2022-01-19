package movie;

public class MovieReservationController {

    public void run() {
        Input input = new HardcodingInput();
        int menu = input.inputMenu();
        MovieScheduleRepository movieScheduleRepository = new MovieScheduleRepository();
        movieScheduleRepository.addSchedule(new MovieSchedule(new Movie(1L), 11));

        switch (menu) {
            case 1:
                movieScheduleRepository.printSeats();
                int row = input.inputRow();
                int column = input.inputColumn();
                movieScheduleRepository.reserve(row, column);
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("d");
        }
    }
}