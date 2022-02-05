package movie;

import java.util.LinkedHashMap;
import java.util.Map;

class MovieSchedule {
    private Movie movie;
    private Map<RowColumnPair, Seat> seats = new LinkedHashMap<>();

    public MovieSchedule(Movie movie) {
        this.movie = movie;
        this.initializeSeats();
    }

    private void initializeSeats() {
        seats.put(new RowColumnPair(1, 1), new Seat(1, 1, false));
        seats.put(new RowColumnPair(1, 2), new Seat(1, 2, false));
        seats.put(new RowColumnPair(1, 3), new Seat(1, 3, false));
    }

    public Seat findSeat(int row, int column) {
        return seats.get(new RowColumnPair(row, column)); //Wrapper type인데 (참조로)null을 반환하는 것이 되겠지?
    }
}