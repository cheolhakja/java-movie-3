package movie;

public class CannotFindSeatException extends IllegalArgumentException {

    public static final String CANNOT_FIND_SEAT_MESSAGE = "좌석을 찾을 수 없습니다";

    public CannotFindSeatException() {
        super(CANNOT_FIND_SEAT_MESSAGE);
    }
}