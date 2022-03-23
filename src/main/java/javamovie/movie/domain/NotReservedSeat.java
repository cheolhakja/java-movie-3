package javamovie.movie.domain;

public class NotReservedSeat implements ISeat {

    private final Long id;
    private final boolean reservationStatus;
    private final RowColumnPair rowColumnPair;

    public NotReservedSeat(Long id, RowColumnPair rowColumnPair) {
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
        return new ReservedSeat(this.id, this.rowColumnPair);
    }
}
