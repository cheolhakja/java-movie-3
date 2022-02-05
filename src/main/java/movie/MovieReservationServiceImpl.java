package movie;

public class MovieReservationServiceImpl implements MovieReservationServiceInterface {

    private final MovieScheduleRepositoryInterface movieScheduleRepository = new MovieScheduleRepositoryImpl(); //바뀌면 안된다..

    @Override
    public boolean reserve(int row, int column) {
        try {
            //need add: row and column validator (not in controller)
            MovieSchedule movieSchedule = movieScheduleRepository.findSchedule();
            Seat seat = movieSchedule.findSeat(row, column);

            SeatNullChecker.check(seat);
            seat.reserved();

            movieScheduleRepository.saveSchedule(movieSchedule); //이 줄을 실행할 때 생기는 에러중에는 서비스 계층으로 throw 할 것이 있고 아닌 것이 있다. ex) SQLException

            System.out.println("예매되었습니다");
            return true;
        } catch(CannotReserveException e) {
            System.out.println("예매 불가능합니다");
            return false;
            //다시 메뉴 입력으로 되돌아가기
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