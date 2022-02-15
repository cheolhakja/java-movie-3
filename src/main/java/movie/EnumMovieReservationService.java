package movie;

public class EnumMovieReservationService implements MovieReservationServiceInterface {

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
        MovieSchedule movieSchedule = movieScheduleRepository.findSchedule();

        movieSchedule.printSeats();
    }
}