package javamovie.service;

import javamovie.domain.MovieSchedule;

public interface MovieReservationService {

    public boolean reserve(int row, int column);

    public void addSchedule(MovieSchedule movieSchedule);

    public void printSeats();
}