package javamovie.movie.domain;

import javamovie.movie.exception.CannotBookException;

public class BookedSeat implements ISeat {

    private final Long id;
    private final boolean reservationStatus;
    private final RowColumnPair rowColumnPair;

    public BookedSeat(Long id, RowColumnPair rowColumnPair) {
        this.id = id;
        this.reservationStatus = true;
        this.rowColumnPair = rowColumnPair;
    }

    @Override
    public boolean reserve() throws CannotBookException {
        throw new CannotBookException();
    }

    @Override
    public void printSeat(int previousRow) {
    }

    @Override
    public RowColumnPair rowColumnPair() {
        return this.rowColumnPair;
    }

    @Override
    public Long seatId() {
        return this.id;
    }

    @Override
    public ISeat bookingResult() throws CannotBookException {
        throw new CannotBookException();
    }
}
