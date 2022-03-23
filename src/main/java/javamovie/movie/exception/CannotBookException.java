package javamovie.movie.exception;

public class CannotBookException extends IllegalArgumentException {

    public static final String CANNOT_RESERVE_MESSAGE = "예매할 수 없습니다";

    public CannotBookException() {
        super(CANNOT_RESERVE_MESSAGE);
    }
}