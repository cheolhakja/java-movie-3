package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Optional;

public class Seats {

    private Map<RowColumnPair, ISeat> seating = new LinkedHashMap<>();

    public Seats(ISeat... seats) {
        for (ISeat seat : seats) {
            this.seating.put(seat.rowColumnPair(), seat);
        }
    }

    public ISeat seatToReserve(int row, int column) throws CannotFindSeatException {
        return Optional.ofNullable(seating.get(new RowColumnPair(row, column)))
                .orElseThrow(() -> new CannotFindSeatException());
    }

    public void updateBookingStatus(RowColumnPair rowColumnPair, ISeat seat) throws CannotFindSeatException {
        ISeat replacedSeat = seating.replace(rowColumnPair, seat);

        if(replacedSeat == null) {
            throw new CannotFindSeatException();
        }
    }
}