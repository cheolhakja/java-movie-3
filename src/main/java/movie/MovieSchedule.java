package movie;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.EnumMap;

class MovieSchedule {
    private Movie movie;
    private Map<RowColumnPair, Seat> seats = new LinkedHashMap<>();
    private Map<SeatPosition, Seat> enumSeats = new EnumMap<>(SeatPosition.class);

    public MovieSchedule(Movie movie) {
        this.movie = movie;
        this.initializeSeats();
        this.initializeEnumSeats();
    }

    private void initializeSeats() {
        seats.put(new RowColumnPair(1, 1), new Seat(1, 1));
        seats.put(new RowColumnPair(1, 2), new Seat(1, 2));
        seats.put(new RowColumnPair(1, 3), new Seat(1, 3));
    }

    private void initializeEnumSeats() {
        enumSeats.put(SeatPosition.A1, new Seat(1,1));
        enumSeats.put(SeatPosition.A2, new Seat(1,2));
        enumSeats.put(SeatPosition.A3, new Seat(1,3));
    }

    public Seat findSeat(int row, int column) {
        return seats.get(new RowColumnPair(row, column)); //Wrapper type인데 (참조로)null을 반환하는 것이 되겠지?
    }

    public void reserve(int row, int column) throws CannotFindSeatException {
        SeatPosition seatPosition = SeatPosition.findSeatPositionByRowColumn(row, column);
        Seat seat = enumSeats.get(seatPosition);

        SeatNullChecker.check(seat);

        seat.reserved();
    }
}