package movie;

public class SeatNullChecker {
    /*
    검증 기능을 엔티티에 두지 않는다. 책임을 여러개 갖게 된다.
     */
    private SeatNullChecker() {

    }

    public static void check(Seat seat) {
        if(seat == null) {
            throw new CannotReserveException();
        }
    }
}