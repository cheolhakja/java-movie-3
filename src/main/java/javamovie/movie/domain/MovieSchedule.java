package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;
import javamovie.movie.exception.CannotBookException;

public class MovieSchedule {

    private Movie movie;
    private Seats mySeats = new Seats();

    public MovieSchedule(Movie movie, RowColumnPair... rowColumnPairs) {
        this.movie = movie;
        for (RowColumnPair rowColumnPair : rowColumnPairs) {
            mySeats.put(rowColumnPair);
        }
    }

    public boolean book(int row, int column) throws CannotFindSeatException, CannotBookException {
        mySeats.updateBookingStatus(new RowColumnPair(row, column),
                mySeats.seatToBook(new RowColumnPair(row, column)).bookingResult());

        return true;
    }

    public void printSeats() {
        int previousRow = 1;

        for (ISeat seat : mySeats.mapToList()) {
            seat.printSeat(previousRow);
            previousRow = seat.rowColumnPair().getRow();
        }

        System.out.println();
    }
}