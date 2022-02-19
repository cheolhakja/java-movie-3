package movie;

public class MovieReservationServiceImpl implements MovieReservationService {

    private MovieScheduleRepository movieScheduleRepository = new MovieScheduleRepositoryImpl();

    @Override
    public boolean reserve(int row, int column) {
        try {
            MovieSchedule movieSchedule = movieScheduleRepository.findSchedule(); //한줄에 점을 두개 이상 찍지 않는다

            movieSchedule.reserve(row, column);
            System.out.println("예매되었습니다");

            return true;
        } catch (CannotReserveException e) {
            System.out.println("이미 예매 된 좌석입니다");
            return false;
        } catch (CannotFindSeatException e) {
            System.out.println("존재하지 않는 좌석입니다");
            return false;
        }
    }

    @Override
    public void addSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.saveSchedule(movieSchedule);
    }

    @Override
    public void printSeats() {
        MovieSchedule movieSchedule = movieScheduleRepository.findSchedule();

        movieSchedule.printSeats();
    }
}