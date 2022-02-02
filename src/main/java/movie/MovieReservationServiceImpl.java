package movie;

import java.util.Map;

public class MovieReservationServiceImpl implements MovieReservationServiceInterface {

    private final MovieScheduleRepositoryInterface movieScheduleRepository = new MovieScheduleRepositoryImpl(); //바뀌면 안된다..

    /*
        MovieSchedule클래스는 그냥 상태를 바꾸는 역할만 수행하는것이다.

    */

    @Override
    public boolean reserve(int row, int column) {
        try {
            //need add: row and column validator (not in controller)
            MovieSchedule movieSchedule = movieScheduleRepository.findSchedule();
            Map<RowColumnPair, Seat> seats = movieSchedule.getAllSeats();
            Seat seat = seats.get(new RowColumnPair(row, column)); //Map에서 'null' 또는 값 반환
            //try - catch형식으로 맞추려고 일부러 findAll 메서드를 만들었음.

            ReservationChecker.check(seat);
            //Validator를 만드는 것이 좋을 듯 싶다. 단일책임. 인덴트는 하나로만 유지하라는 말씀이 있었다. Validator에서 throw하게 하면 될 듯.

            seat.setBooked(true);
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