package javamovie.movie.domain;

import javamovie.movie.exception.CannotReserveException;

public class ReservedSeat implements ISeat {

    private final Long id;
    private final boolean reservationStatus;
    private final RowColumnPair rowColumnPair;

    public ReservedSeat(Long id, RowColumnPair rowColumnPair) {
        this.id = id;
        this.reservationStatus = true;
        this.rowColumnPair = rowColumnPair;
    }

    @Override
    public boolean reserve() throws CannotReserveException {
        throw new CannotReserveException();
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
    public ISeat bookingResult() throws CannotReserveException {
        throw new CannotReserveException();
    }
}
