package javamovie;

import javamovie.controller.MovieTicketBookingController;

public class Main {

    public static void main(String[] args) {
        MovieTicketBookingController movieTicketBookingController = new MovieTicketBookingController();
        movieTicketBookingController.run();
    }
}