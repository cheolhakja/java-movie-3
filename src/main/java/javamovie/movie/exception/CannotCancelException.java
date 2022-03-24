package javamovie.movie.exception;

public class CannotCancelException extends IllegalArgumentException {

    public static final String CANNOT_CANCEL_SEAT_MESSAGE = "좌석을 취소할 수 없습니다";

    public CannotCancelException() {
        super(CANNOT_CANCEL_SEAT_MESSAGE);
    }
}
