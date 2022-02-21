package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;

import java.util.LinkedHashMap;
import java.util.Map;

public class MovieSchedule {

    private Movie movie;
    private Map<RowColumnPair, Seat> seats = new LinkedHashMap<>();

    public MovieSchedule(Movie movie, RowColumnPair... rowColumnPairs) {
        Long id = 0L;

        this.movie = movie;

        for (RowColumnPair rowColumnPair : rowColumnPairs) {
            id = id + 1L;
            seats.put(rowColumnPair, new Seat(id, rowColumnPair));
        }
    }

    public boolean reserve(int row, int column) throws CannotFindSeatException {
        Seat seat = seats.get(new RowColumnPair(row, column));

        SeatExistenceChecker.check(seat); //need refactor: seat-existence-checker

        return seat.reserved();
    }

    public void printSeats() {
        int previousSeatRow = 1;
        int row;

        for (Map.Entry<RowColumnPair,Seat> entry : seats.entrySet()) {
            if ((row = entry.getKey().getRow()) > previousSeatRow) {
                System.out.println();
                previousSeatRow = row;
            }

            entry.getValue().printSeat();
        }

        System.out.println();
    }
}