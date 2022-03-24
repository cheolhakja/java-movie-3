package javamovie.movie.domain;

import javamovie.movie.exception.CannotCancelException;

public class NotBookedSeat implements ISeat {

    private final Long id;
    private final boolean reservationStatus;
    private final RowColumnPair rowColumnPair;

    public NotBookedSeat(Long id, RowColumnPair rowColumnPair) {
        this.id = id;
        this.reservationStatus = false;
        this.rowColumnPair = rowColumnPair;
    }

    @Override
    public boolean reserve() {
        return true;
    }

    @Override
    public void printSeat(int previousRow) {
        if(previousRow < this.rowColumnPair.getRow()) {
            System.out.println();
        }

        System.out.print(" " + this.rowColumnPair.getRow() + "행" + this.rowColumnPair.getColumn() + "열:O");
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
    public ISeat bookingResult() {
        return new BookedSeat(this.id, this.rowColumnPair);
    }

    @Override
    public ISeat cancelingResult() throws CannotCancelException {
        throw new CannotCancelException();
    }
}
