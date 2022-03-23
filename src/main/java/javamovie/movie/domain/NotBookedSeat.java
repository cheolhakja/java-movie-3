package javamovie.movie.domain;

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
}
