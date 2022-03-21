package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Optional;

public class Seats {

    private Map<RowColumnPair, Seat> seating = new LinkedHashMap<>();

    public Seats(Seat... seats) {
        for (Seat seat : seats) {
            this.seating.put(seat.rowColumnPair(), seat);
        }
    }

    public Seat seatToReserve(int row, int column) throws CannotFindSeatException {
        return Optional.ofNullable(seating.get(new RowColumnPair(row, column)))
                .orElseThrow(() -> new CannotFindSeatException());
    }
}