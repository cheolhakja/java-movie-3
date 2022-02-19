package javamovie;

import javamovie.controller.MovieReservationController;

public class Main {

    public static void main(String[] args) {
        MovieReservationController movieReservationController = new MovieReservationController();
        movieReservationController.run();
    }
}