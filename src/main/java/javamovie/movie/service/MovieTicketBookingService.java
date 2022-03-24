package javamovie.movie.service;

import javamovie.movie.domain.MovieSchedule;

public interface MovieTicketBookingService {

    public boolean reserve(int row, int column);

    public void addSchedule(MovieSchedule movieSchedule);

    public void printSeats();

    public void cancel(int row, int column);
}