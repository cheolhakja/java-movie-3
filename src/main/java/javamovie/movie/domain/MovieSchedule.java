package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;
import javamovie.movie.exception.CannotReserveException;

public class MovieSchedule {

    private Movie movie;
    private Seats mySeats = new Seats();

    public MovieSchedule(Movie movie, RowColumnPair... rowColumnPairs) {
        this.movie = movie;
        for (RowColumnPair rowColumnPair : rowColumnPairs) {
            mySeats.put(rowColumnPair);
        }
    }

    public boolean reserve(int row, int column) throws CannotFindSeatException, CannotReserveException {
        mySeats.updateBookingStatus(new RowColumnPair(row, column),
                mySeats.seatToReserve(new RowColumnPair(row, column)).bookingResult());

        return true;
    }

    public void printSeats() {

    }
}