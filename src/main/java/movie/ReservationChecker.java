package movie;

public class ReservationChecker {

    private ReservationChecker() {
        //객체 생성을 불허한다
    }

    public static void check(Seat seat) throws CannotReserveException {
        if(seat.isBooked()) {
            throw new CannotReserveException();
        }
    }
}