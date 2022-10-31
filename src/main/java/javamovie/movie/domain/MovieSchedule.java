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
                mySeats.seat(new RowColumnPair(row, column)).bookingResult());

        return true;
    }

    public void printSeats() {
        System.out.println("예매 현황입니다");

        int previousRow = 1;

        for (ISeat seat : mySeats.mapToList()) {
            seat.printSeat(previousRow);
            previousRow = seat.rowColumnPair().getRow();
        }

        System.out.println();
    }

    public void cancel(int row, int column) {
        mySeats.updateBookingStatus(new RowColumnPair(row, column), mySeats.seat(new RowColumnPair(row, column)).cancelingResult());
    }

    public boolean equalMovie(Movie movie) {
        return this.movie.equals(movie);
    }
}