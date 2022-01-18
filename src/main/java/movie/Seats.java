package movie;

import java.util.Map;
import java.util.LinkedHashMap;

public class Seats {

    private Map<RowColumnPair, Seat> seats = new LinkedHashMap<RowColumnPair, Seat>();

    public Seats() {
        this.initializeSeats();
    }

    public boolean isBooked(int row, int column) {
        if (seats.containsKey(new RowColumnPair(row, column))) {
            return seats.get(new RowColumnPair(row, column)).isBooked();
        }

        return false;
    }

    public boolean reserve(int row, int column) {
        if (seats.containsKey(new RowColumnPair(row, column)) && !isBooked(row, column)) {
            seats.replace(new RowColumnPair(row, column), new Seat(row, column, true));
            return true;
        }

        throw new CannotReserveException();
    }

    private void initializeSeats() {
        seats.put(new RowColumnPair(1, 1), new Seat(1, 1, false));
        seats.put(new RowColumnPair(1, 2), new Seat(1, 2, false));
        seats.put(new RowColumnPair(1, 3), new Seat(1, 3, false));
    }
}