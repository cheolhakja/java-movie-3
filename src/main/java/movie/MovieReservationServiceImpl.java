package movie;

public class MovieReservationServiceImpl implements MovieReservationServiceInterface {

    private final MovieScheduleRepositoryInterface movieScheduleRepository = new MovieScheduleRepositoryImpl(); //바뀌면 안된다..

    @Override
    public boolean reserve(int row, int column) {
        MovieSchedule movieSchedule = movieScheduleRepository.findSchedule();
        Seat seat = movieSchedule.getSeat(row, column);

        if(seat.isBooked()) {
            throw new CannotReserveException();
        }

        seat.setBooked(true);
        movieScheduleRepository.saveSchedule(movieSchedule);
        return true;
        /*
        MovieSchedule클래스는 그냥 상태를 바꾸는 역할만 수행하는것이다.
        Repository를 통해서 저장하는 것이 좋을 것 같다
        try - catch - finally
        지금 당장 할 수 있는 작은 일을 하고 테스트 해보자.

         */
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