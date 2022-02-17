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

    public MovieSchedule(Movie movie, SeatPosition... seatPositions) {
        this.movie = movie;
        for (SeatPosition seatPosition : seatPositions) {
            enumSeats.put(seatPosition, new Seat(seatPosition));
        }
    }

    public MovieSchedule(Movie movie, RowColumnPair... rowColumnPairs) {
        Long id = 0L;

        this.movie = movie;

        for (RowColumnPair rowColumnPair : rowColumnPairs) {
            id = id + 1L;
            seats.put(rowColumnPair, new Seat(id, rowColumnPair));
        }
    }

    private void initializeSeats() {
        seats.put(new RowColumnPair(1, 1), new Seat(1, 1));
        seats.put(new RowColumnPair(1, 2), new Seat(1, 2));
        seats.put(new RowColumnPair(1, 3), new Seat(1, 3));
    }

    private void initializeEnumSeats() {
        enumSeats.put(SeatPosition.A1, new Seat(1, 1));
        enumSeats.put(SeatPosition.A2, new Seat(1, 2));
        enumSeats.put(SeatPosition.A3, new Seat(1, 3));
    }

    public Seat findSeat(int row, int column) {
        return seats.get(new RowColumnPair(row, column)); //Wrapper type인데 (참조로)null을 반환하는 것이 되겠지?
    }

    public boolean reserve(int row, int column) throws CannotFindSeatException {
        Seat seat = seats.get(new RowColumnPair(row, column));

        SeatNullChecker.check(seat); //need refactor: seat-existence-checker

        return seat.reserved();
    }

    public void printSeats() {
        int previousSeatRow = 1;
        int row;

        for (Map.Entry<SeatPosition, Seat> seat : enumSeats.entrySet()) {
            if ((row = seat.getKey().getRow()) > previousSeatRow) { //한 줄에 점 두개. 메세지를 보내기
                System.out.println();
                previousSeatRow = row;
            }

            seat.getValue().printSeat();
        }
    }
}