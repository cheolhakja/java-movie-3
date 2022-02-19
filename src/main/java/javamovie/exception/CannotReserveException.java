package javamovie.exception;

public class CannotReserveException extends IllegalArgumentException {

    public static final String CANNOT_RESERVE_MESSAGE = "예매할 수 없습니다";

    public CannotReserveException() {
        super(CANNOT_RESERVE_MESSAGE);
    }
}