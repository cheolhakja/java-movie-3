package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;

import java.util.*;

public class Seats {

    private Long primaryKey = 0L;
    private Map<RowColumnPair, ISeat> seating = new LinkedHashMap<>();

    public Seats(ISeat... seats) {
        for (ISeat seat : seats) {
            this.seating.put(seat.rowColumnPair(), seat);
        }
    }

    public ISeat seat(RowColumnPair rowColumnPair) throws CannotFindSeatException {
        return Optional.ofNullable(seating.get(rowColumnPair))
                .orElseThrow(() -> new CannotFindSeatException());
    }

    public void updateBookingStatus(RowColumnPair rowColumnPair, ISeat seat) throws CannotFindSeatException {
        ISeat replacedSeat = seating.replace(rowColumnPair, seat);

        if(replacedSeat == null) {
            throw new CannotFindSeatException();
        }
    }

    public void put(RowColumnPair rowColumnPair) {
        this.seating.put(rowColumnPair, new NotBookedSeat(++primaryKey, rowColumnPair));
    }

    public List<ISeat> mapToList() {
        return new ArrayList<ISeat>(seating.values());
    }
}