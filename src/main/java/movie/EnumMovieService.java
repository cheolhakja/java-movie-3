package movie;

public class EnumMovieService implements MovieReservationServiceInterface {

    private MovieScheduleRepositoryInterface movieScheduleRepository = new MovieScheduleRepositoryImpl();

    @Override
    public boolean reserve(int row, int column) {
        try {
            MovieSchedule movieSchedule = movieScheduleRepository.findSchedule(); //한줄에 점을 두개 이상 찍지 않는다

            movieSchedule.reserve(row, column);

            return true;
        } catch (CannotReserveException e) {
            return false;
        } catch (CannotFindSeatException e) {
            return false;
        }
    }

    @Override
    public void addSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.saveSchedule(movieSchedule);
    }

    @Override
    public void printSeats() {
        //repository에서 findAll등의 메서드만 가져야한다.
    }
}