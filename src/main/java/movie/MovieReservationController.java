package movie;

public class MovieReservationController {

    public void run() {
        Input input = new ConsoleInput();
        MovieReservationServiceInterface movieReservationService = new MovieReservationServiceImpl();

        movieReservationService.addSchedule(new MovieSchedule(new Movie(1L)));

        while(true) {
            int menu = input.inputMenu();
            switch (menu) {
                case 1:
                    int row = input.inputRow();
                    int column = input.inputColumn();
                    movieReservationService.reserve(row, column);
                    break;
                case 2:
                    System.out.println("2");
                    break;
                default:
                    throw new IllegalArgumentException(); //나올 수 없는 메뉴 입력값
            }
        }
    }
}